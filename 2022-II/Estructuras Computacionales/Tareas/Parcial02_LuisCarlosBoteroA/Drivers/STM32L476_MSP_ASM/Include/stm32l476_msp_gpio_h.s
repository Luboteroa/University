/*
 * stm32l476_msp_gpio_h.s
 *
 *  Created on: Sep 19, 2022
 *      Author: gosor
 */
.syntax unified

.include "stm32l476_constants.s"

.global GPIO_MODER_Init
.global GPIO_OTYPER_Init
.global GPIO_PUPDR_Init
.global GPIO_Set
.global GPIO_Clear
.global GPIO_Toggle
.global GPIO_Read
