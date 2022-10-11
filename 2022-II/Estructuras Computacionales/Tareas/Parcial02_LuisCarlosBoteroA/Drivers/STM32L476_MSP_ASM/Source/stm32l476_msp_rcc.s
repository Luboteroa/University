/*
 * stm32l476_msp_rcc.s
 *
 *  Created on: Sep 19, 2022
 *      Author: gosor
 */


.include "stm32l476_msp_rcc_h.s"

.section .text.RCC_AHB2ENR_Init
.type 	RCC_AHB2ENR_Init,%function
RCC_AHB2ENR_Init:
	ldr r4,[r0,RCC_AHB2ENR]
	orr r4,r1
	str r4,[r0,RCC_AHB2ENR]
	bx lr
.size	RCC_AHB2ENR_Init,.-RCC_AHB2ENR_Init
