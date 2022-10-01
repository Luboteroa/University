/*
 * main.s
 *
 *  Created on: Aug 28, 2022
 *      Author: Samuel
 */


.syntax unified

.global main

// Constants defined in file stm32L476xx_constants.S
// 	 RCC   base address is 0x40021000
//   AHB2ENR register offset is 0x4C
// 	 RCC   base address is 0x40021000
//   APB2ENR register offset is 0x60
.equ	RCC_BASE, 	 	0x40021000
.equ    RCC_AHB2ENR,   	0x4C // RCC AHB2 peripheral clock reg (RM0351, page 251)



// 	 GPIOA base address is 0x48000000
//   MODER register offset is 0x00
//   ODR   register offset is 0x14
.equ	GPIOA_BASE, 	0x48000000 // GPIO BASE ADDRESS (RM0351, page 78)
.equ	GPIOB_BASE,		0x48000400 // GPIO BASE ADDRESS (RM0351, page 78)

.equ    GPIO_MODER,   	0x00 // GPIO port mode register (RM0351, page 303)
.equ    GPIO_ODR,     	0x14 // GPIO outpu data register (RM0351, page 306)
.equ	GPIO_PUPDR,		0x0C // GPIO port pull-up/pull-down RM0351 page 305
.equ	GPIO_OTYPER,		0x04 // GPIO Output type register RM0351 page 304

.section .text.main
.type	main,%function
main:

// ACTIVAR EL RELOJ DE LOS PUERTOS A Y B
	ldr r6, =RCC_BASE
	ldr r5, [r6,#RCC_AHB2ENR]
	orr r5, 0x00000003	// Se coloca un 3 ya que estamos colocando un 1 en el bit 0 y 1 que corresponden a los puertos A Y B
	str r5, [r6,#RCC_AHB2ENR]

// CONFIGURACION PINES MFShield, pines A5, A6, A7, B6

// CONFIGURACION GPIOx_MODER DE LOS PINES

//A5
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_MODER]
	orr r5, #(1<<10)          	// Colocamos el bit 10 en 1
	bfc r5, #11, #1          	// Colocamos el bit 11 en 0
	str r5, [r6,#GPIO_MODER]
//A6
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_MODER]
	orr r5, #(1<<12)          	// Colocamos el bit 12 en 1
	bfc r5, #13, #1          	// Colocamos el bit 13 en 0
	str r5, [r6,#GPIO_MODER]
//A7
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_MODER]
	orr r5, #(1<<14)          	// Colocamos el bit 14 en 1
	bfc r5, #15, #1          	// Colocamos el bit 15 en 0
	str r5, [r6,#GPIO_MODER]
//B6
	ldr r6, =GPIOB_BASE
	ldr r5, [r6,#GPIO_MODER]
	orr r5, #(1<<12)          	// Colocamos el bit 12 en 1
	bfc r5, #13, #1          	// Colocamos el bit 13 en 0
	str r5, [r6,#GPIO_MODER]

///////////////////////////////////////////////////////////////////////////////////
// CONFIGURACION GPIOx_OTYPER DE LOS PINES

//A5
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_OTYPER]
	orr r5, #(1<<5)          	// Colocamos el bit 5 en 1 (configuracion Open-Drain)
	str r5, [r6,#GPIO_OTYPER]
//A6
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_OTYPER]
	orr r5, #(1<<6)          	// Colocamos el bit 6 en 1 (configuracion Open-Drain)
	str r5, [r6,#GPIO_OTYPER]
//A7
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_OTYPER]
	orr r5, #(1<<7)          	// Colocamos el bit 7 en 1 (configuracion Open-Drain)
	str r5, [r6,#GPIO_OTYPER]
//B6
	ldr r6, =GPIOB_BASE
	ldr r5, [r6,#GPIO_OTYPER]
	orr r5, #(1<<6)          	// Colocamos el bit 6 en 1 (configuracion Open-Drain)
	str r5, [r6,#GPIO_OTYPER]

///////////////////////////////////////////////////////////////////////////////////
// CONFIGURACION GPIOx_PUPDR DE LOS PINES

//A5
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_PUPDR]
	bfc r5, #10, #2       		// Colocamos el bit 10 y 11  en 0 (configuracion  No pull-up, pull-down)
	str r5, [r6,#GPIO_PUPDR]
//A6
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_PUPDR]
	bfc r5, #12, #2          	// Colocamos el bit 12 y 13  en 0 (configuracion  No pull-up, pull-down)
	str r5, [r6,#GPIO_PUPDR]
//A7
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_PUPDR]
	bfc r5, #14, #2            	// Colocamos el bit 14 y 15  en 0 (configuracion  No pull-up, pull-down)
	str r5, [r6,#GPIO_PUPDR]
//B6
	ldr r6, =GPIOB_BASE
	ldr r5, [r6,#GPIO_PUPDR]
	bfc r5, #12, #2         	// Colocamos el bit 12 y 13  en 0 (configuracion  No pull-up, pull-down)
	str r5, [r6,#GPIO_PUPDR]

///////////////////////////////////////////////////////////////////////////////////
// CONFIGURACION GPIOx_ODR DE LOS PINES

//A5
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_ODR]
	bfc r5, #5, #1         	//Colocamos el bit 5 en 0 (High)
	str r5, [r6,#GPIO_ODR]
//A6
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_ODR]
	bfc r5, #6, #1         	//Colocamos el bit 6 en 0 (High)
	str r5, [r6,#GPIO_ODR]       	//Colocamos el bit 6 en 0 (High)
//A7
	ldr r6, =GPIOA_BASE
	ldr r5, [r6,#GPIO_ODR]
	bfc r5, #7, #1         	//Colocamos el bit 7 en 0 (High)
	str r5, [r6,#GPIO_ODR]       	//Colocamos el bit 5 en 0 (High)
//B6
	ldr r6, =GPIOB_BASE
	ldr r5, [r6,#GPIO_ODR]
	bfc r5, #5, #1         	//Colocamos el bit 6 en 0 (High)
	str r5, [r6,#GPIO_ODR]


loop:
	 nop
	 nop
	 nop
	b loop
.size	main, .-main
