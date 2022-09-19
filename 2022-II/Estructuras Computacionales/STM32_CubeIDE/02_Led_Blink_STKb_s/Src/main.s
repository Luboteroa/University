/*
 * main.s
 *
 *  Created on: Sep 5, 2022
 *      Author: danin
 */
.syntax unified
.include "stm32l476_constants.s"
.global main

.section	.text.main
.type main,%function
main:
	ldr r0, =RCC_BASE
	mov r1,1
	bl DRV_RCC_AHB2ENR_Init

	ldr r0, =GPIOA_BASE
	movw r1, (1<<10)
	movt r1, 0
	movw r2, (1<<11)
	movt r2, 0

	bl DRV_GPIOx_MODER_Init

	ldr r0, =GPIOA_BASE
	mov r1,(1<<5)
	bl DRV_GPIOx_Set

loop:
	nop
	b loop

.size main,.-main
