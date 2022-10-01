/*
 * main.s
 *
 *  Created on: Sep 19, 2022
 *      Author: User
 */

.equ GPIOA_BASE, 0x48000000
.equ GPIOB_BASE, 0x48000400
.equ GPIOC_BASE, 0x48000800

.equ    GPIO_MODER,   	0x00 // GPIO port mode register (RM0351, page 303)
.equ 	GPIO_OTYPER, 	0x04
.equ 	GPIO_PUPDR,		0x0C
.equ 	GPIO_IDR, 		0x10
.equ    GPIO_ODR,     	0x14 // GPIO outpu data register (RM0351, page 306)
.equ 	GPIO_BSRR,      0x18
.equ    GPIO_BRR,       0x28

.equ GPIO_ODR, 0x14

.syntax unified
.global main

.section .text.main
.type main,%function

main:
	bl LD2_Init
	bl B1_Init
	bl LD2_Set
loop:
	nop
	b loop

.size main,.-main

//FUNCTIONS
.section .text.LD2_Init
.type LD2_Init,%function
LD2_Init:
	push {lr}
	bl RCC_AHB2ENR_Init

	ldr r0,=GPIOA_BASE
	movw r1,(1<<10)
	movw r2,(1<<11)
	bl GPIO_MODER_Init

	pop {pc}
.size LD2_Init,.-LD2_Init

.section .text.B1_Init
.type B1_Init,%function
B1_Init:

	movw r0,1 //0x5, 5
	bl RCC_AHB2ENR_Init

	ldr r0,=GPIOC_BASE
	movw r1,0
	movt r1,(1<<10)
	movw r2,0
	movt r2,(1<<11)
	bl GPIO_MODER_Init

	bx lr
.size B1_Init,.-B1_Init

.section .text.LD2_Set
.type LD2_Set,%function
LD2_Set:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<5)
	bl GPIO_Set

	pop {pc}
.size LD2_Set,.-LD2_Set

//RCC AHB2ENR INIT
.section .text.RCC_AHB2ENR_Init
.type RCC_AHB2ENR_Init,%function
RCC_AHB2ENR_Init:

	bx lr
.size RCC_AHB2ENR_Init,.-RCC_AHB2ENR_Init

//GPIO MODER INIT
.section .text.GPIO_MODER_Init
.type GPIO_MODER_Init,%function
GPIO_MODER_Init:

	bx lr
.size GPIO_MODER_Init,.-GPIO_MODER_Init

//GPIO SET
.section .text.GPIO_Set
.type GPIO_Set,%function
GPIO_Set:
	// Read Output data register (ODR)
	// for port in r4
	//ldr r4,=[r0,GPIO_ODR]
	//orr r4,r1
	//str r4,[r0, GPIO_ODR]
	str r1,[r0, GPIO_BSRR]
	bx lr
.size GPIO_Set,.-GPIO_Set

//CLEAR
.section .text.GPIO_Clear
.type GPIO_Clear,%function
GPIO_Clear:
	// Clear bits to 0 where we had 1's
	str r1,[r0, GPIO_BRR]
	bx lr
.size GPIO_Clear,.-GPIO_Clear
