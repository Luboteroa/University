/*
 * stm32l476_constants.s
 *
 *  Created on: Sep 19, 2022
 *      Author: gosor
 */
// Constants defined in file stm32L476xx_constants.S
// 	 RCC   base address is 0x40021000
//   AHB2ENR register offset is 0x4C
// 	 RCC   base address is 0x40021000
//   APB2ENR register offset is 0x60
.equ	RCC_BASE, 	 	0x40021000
.equ    RCC_AHB2ENR,   	0x4C // RCC AHB2 peripheral clock reg (RM0351, page 251) Para el pueto A
.equ	RCC_APB2ENR,   	0x60 // RCC APB2 peripheral clock reg (RM0351, page 258) Para el SysTick


.equ 	GPIOA_BASE, 0X48000000
.equ 	GPIOB_BASE, 0X48000400
.equ 	GPIOC_BASE, 0X48000800

.equ    GPIO_MODER,   	0x00 // GPIO port mode register (RM0351, page 303)
.equ 	GPIO_OTYPER, 	0x04
.equ 	GPIO_OSPEEDR,   0x08
.equ 	GPIO_PUPDR,		0x0C
.equ 	GPIO_IDR, 		0x10
.equ    GPIO_ODR,     	0x14 // GPIO outpu data register (RM0351, page 306)
.equ 	GPIO_BSRR,		0x18
.equ	GPIO_LCKR, 		0x1C
.equ	GPIO_AFRL, 		0x20
.equ	GPIO_AFRH, 		0x24
.equ	GPIO_BRR, 		0x28
.equ	GPIO_ASCR, 		0x2C

.equ 	SysTick_BASE,	0xE000E010
.equ 	SysTick_CTRL,	0x0		// SysTick Control and Status Register
.equ 	SysTick_LOAD,	0x4		// SysTick reload Value Register
.equ 	SysTick_VAL,	0x8		// SysTick Current Value Register
.equ 	SysTick_CALIB,	0xC		// SysTick Calibration Register

.equ 	SCB_BASE,		0xE000ED00
.equ 	SCB_SHP,		0x20
