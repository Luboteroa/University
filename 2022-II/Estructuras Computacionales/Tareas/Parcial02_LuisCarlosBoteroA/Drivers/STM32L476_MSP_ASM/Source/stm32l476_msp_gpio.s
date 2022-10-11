/*
 * stm32l476_msp_gpio.s
 *
 *  Created on: Sep 19, 2022
 *      Author: gosor
 */

.include "stm32l476_msp_gpio_h.s"


.section .text.GPIO_MODER_Init
.type 	GPIO_MODER_Init,%function
GPIO_MODER_Init:
	ldr r4,[r0,GPIO_MODER]
	orr r4,r1
	bic r4,r2
	str r4,[r0,GPIO_MODER]
	bx lr
.size	GPIO_MODER_Init,.-GPIO_MODER_Init


.section .text.GPIO_PUPDR_Init
.type 	GPIO_PUPDR_Init,%function
GPIO_PUPDR_Init:
	ldr r4,[r0,GPIO_PUPDR]
	orr r4,r1
	bic r4,r2
	str r4,[r0,GPIO_PUPDR]
	bx lr
.size	GPIO_PUPDR_Init,.-GPIO_PUPDR_Init

.section .text.GPIO_OTYPER_Init
.type 	GPIO_OTYPER_Init,%function
GPIO_OTYPER_Init:
	ldr r4,[r0,GPIO_OTYPER]
	orr r4,r1
	bic r4,r2
	str r4,[r0,GPIO_OTYPER]
	bx lr
.size	GPIO_OTYPER_Init,.-GPIO_OTYPER_Init



.section .text.GPIO_Set
.type 	GPIO_Set,%function
GPIO_Set:
	// Read Output Data Register (ODR)
	// for port in r0.
	//ldr r4,[r0,GPIO_ODR]
	//orr r4,r1
	//str r4,[r0,GPIO_ODR]
	str r1,[r0,GPIO_BSRR]
	bx lr
.size	GPIO_Set,.-GPIO_Set

.section .text.GPIO_Clear
.type 	GPIO_Clear,%function
GPIO_Clear:
	// Read Output Data Register (ODR)
	// for port in r0.
	//ldr r4,[r0,GPIO_ODR]
	//orr r4,r1
	//str r4,[r0,GPIO_ODR]
	str r1,[r0,GPIO_BRR]
	bx lr
.size	GPIO_Clear,.-GPIO_Clear

.section .text.GPIO_Toggle
.type 	GPIO_Toggle,%function
GPIO_Toggle:
	// Read Output Data Register (ODR)
	// for port in r0.
	ldr r4,[r0,GPIO_ODR]
	eor r4,r1
	str r4,[r0,GPIO_ODR]

	bx lr
.size	GPIO_Toggle,.-GPIO_Toggle

.section .text.GPIO_Read
.type 	GPIO_Read,%function
GPIO_Read:
	// Read Input Data Register (IDR)
	// for port in R0 and pin in R1
	ldr r0,[r0,GPIO_IDR]
	and r0,r1
	bx lr
.size	GPIO_Read,.-GPIO_Read
