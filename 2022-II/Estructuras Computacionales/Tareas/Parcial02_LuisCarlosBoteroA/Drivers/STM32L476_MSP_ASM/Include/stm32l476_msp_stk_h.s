/*
 * stm32l476_stk_h.s
 *
 *  Created on: Sep 8, 2022
 *      Author: gosor
 */

.syntax unified

.include "stm32l476_constants.s"

.global SysTick_Config
.global GetTick
.global SysTick_Handler
.global Delay
.global STK_Config_Polling
.global STK_Polling
.global STK_Get_msTick
