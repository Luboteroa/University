/*
 * stm32l476_bsp_ng4_asm.s
 *
 *  Created on: Sep 19, 2022
 *      Author: gosor
 */
.include "stm32l476_bsp_n64_h.s"

.section .text.LD2_Init
.type LD2_Init,%function
LD2_Init:
	push {lr}

	ldr r0,=RCC_BASE
	movw r1,1
	bl RCC_AHB2ENR_Init

	ldr r0,=GPIOA_BASE
	movw r1,(1<<10)
	movw r2,(1<<11)
	bl GPIO_MODER_Init

	pop {pc}
	//bx lr
.size LD2_Init,.-LD2_Init

.section .text.B1_Init
.type B1_Init,%function
B1_Init:
	push {lr}

	ldr r0,=RCC_BASE
	movw r1,4
	bl RCC_AHB2ENR_Init


	ldr r0,=GPIOC_BASE
	movw r1,0
	movt r1,0
	movw r2,0
	movt r2,(11<<10)
	bl GPIO_MODER_Init

	pop {pc}
	//bx lr
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

.section .text.LD2_Clear
.type LD2_Clear,%function
LD2_Clear:
	push {lr}

	ldr r0,=GPIOA_BASE
	movw r1,(1<<5)
	bl GPIO_Clear

	pop {pc}
.size LD2_Clear,.-LD2_Clear


.section .text.PB_Read
.type PB_Read,%function
PB_Read:
	push {lr}
	push {r2}
//	ldr r0,=GPIOC_BASE
//	movw r1,(1<<13)
	bl GPIO_Read

// if_b1_read:
	pop {r2}
	mov r1,0
	cbz r0,PB_Read_end_if
	mov r1,1
PB_Read_end_if:
    str r1,[r2]



	pop {pc}
.size PB_Read,.-PB_Read
