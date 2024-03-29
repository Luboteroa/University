/*
 * main.s
 *
 *  Created on: Sep 15, 2022
 *      Author: Luiscarlosb
 */

.include "stm32l476_constants.s"

.syntax unified

.global main

.data
current_tick:	.word	0
last_tick_1:	.word   0
periodo: 		.word  500

.section .text.main
.type main,%function
main:
	ldr r0,=RCC_BASE
	movw r1,0x3 //se puso en 3 porque estamos activando puerto A y B
	movt r1,0 	// RCC_APB2ENR, SYSCFGEN, RM0351 Pg. 259
	bl DRV_RCC_AHB2ENR_Init
//SysTick configuration PM0214 Sec. 4.5 SysTick timer (STK) pg. 246
	ldr r0,=RCC_BASE
	movw r1,0x1
	movt r1,0 	// RCC_APB2ENR, SYSCFGEN, RM0351 Pg. 259
	bl DRV_RCC_APB2ENR_Init

	// Set SysTick_CTRL to disabLe SysTick IRQ and SysTick timer
	ldr r0, =SysTick_BASE

	// Specify the number of cLock cycles between two interrupts
	ldr r2, =3999 // Change it based on interrupt interval
	str r2, [r0, #SysTick_LOAD] // Save to SysTick reload register

	// Clear SysTick current value register (SysTick_VAL)
	mov r1, #0
	str r1, [r0, #SysTick_VAL] // Write e to SysTick value register

	// Set SysTick_CTRL to enable SysTick timer and SysTick interrupt
	ldr r1, [r0, #SysTick_CTRL]
	mov r2,#0x00000005
	orr r1,r1,r2  // Enable SysTick counter & interrupt
	str r1, [r0, #SysTick_CTRL]

//A1, A4, A5, A6, A7, A8
	ldr r0,= GPIOA_BASE
	movw r1,0b0101010000000000
	movt r1,0b0000000000000001
	movw r2,0b1010101100001100
	movt r2,0b0000000000000010
	bl DRV_GPIOx_MODER_Init

//B0, B4, B5, B6, B8
	ldr r0,= GPIOB_BASE
	movw r1,0b0001010100000000
	movt r1,0b0000000000000001
	movw r2,0b0010101000000011
	movt r2,0b0000000000000010
	bl DRV_GPIOx_MODER_Init


loop:
	ldr r0, =SysTick_BASE
	ldr r1, [r0, #SysTick_CTRL]
	and r1,(1<<16)
	cbz r1,endreadtick
	ldr r0,=current_tick
	ldr r1,[r0]
	add r1,1
	str r1,[r0]

endreadtick:
	ldr r0,=current_tick
	ldr r0,[r0]
	ldr r1,=last_tick_1
	ldr r1,[r1]
	sub r0,r1
	ldr r4,=periodo
	ldr r6,[r4]
	cmp r0,r6
	blt endledtoggle
	ldr r0,=current_tick
	ldr r0,[r0]
	ldr r1,=last_tick_1
    str r0,[r1]

//A5, A6, A7, A8
	ldr r0,=GPIOA_BASE
	movw r1,0b111100000
	bl DRV_GPIOx_Toggle

//B4, B5, B6, B8
	ldr r0,=GPIOB_BASE
	movw r1,0b101110000
	bl DRV_GPIOx_Toggle

//Botones
//B0
	ldr r2, =GPIOB_BASE
	ldr r1, [r2,#GPIO_IDR]

	and	r1, r1, #0x0001
	ldr r3, =0x0000
	cmp r1, r3
	beq encender_gpioB

//A1
	ldr r2, =GPIOA_BASE
	ldr r1, [r2,#GPIO_IDR]

	and	r1, r1, #0x0002
	ldr r3, =0x0000
	cmp r1, r3
	beq encender_gpioA

//A4
	ldr r2, =GPIOA_BASE
	ldr r1, [r2,#GPIO_IDR]

	and	r1, r1, #0x0010
	ldr r3, =0x0000
	cmp r1, r3
	beq led_on


encender_gpioA:

	//A5, A6, A7, A8
	ldr r0,=GPIOA_BASE
	movw r1,0b111100000
	bl DRV_GPIOx_Set
	b endledtoggle

encender_gpioB:
	//B4, B5, B6, B8
	ldr r0,=GPIOB_BASE
	movw r1,0b101110000
	bl DRV_GPIOx_Set
	b endledtoggle
	b endledtoggle

led_on:
//A5, A6, A7, A8
	ldr r0,=GPIOA_BASE
	movw r1,0b111100000
	bl DRV_GPIOx_Set

//B4, B5, B6, B8
	ldr r0,=GPIOB_BASE
	movw r1,0b101110000
	bl DRV_GPIOx_Set
	b endledtoggle

endledtoggle:
	b loop
.size main,.-main
