/*
 * hal_nucleo_l476.h
 *
 *  Created on: Oct 14, 2022
 *      Author: gosor
 */

#ifndef INCLUDE_HAL_NUCLEO_L476_H_
#define INCLUDE_HAL_NUCLEO_L476_H_

#include "stm32l4xx_ll_bus.h"
#include "stm32l4xx_ll_utils.h"
#include "stm32l4xx_ll_gpio.h"



/* ==============   BOARD SPECIFIC CONFIGURATION CODE BEGIN    ============== */
/**
 * @brief LED2 - Nucleo 64
 */

#define LD0		LL_GPIO_PIN_3 //Puerto B
#define LD0_PORT           GPIOB
#define LD0_CLK_ENABLE()   LL_AHB2_GRP1_EnableClock(LL_AHB2_GRP1_PERIPH_GPIOB )

#define LD1		LL_GPIO_PIN_5 //Puerto B
#define LD1_PORT           GPIOB
#define LD1_CLK_ENABLE()   LL_AHB2_GRP1_EnableClock(LL_AHB2_GRP1_PERIPH_GPIOB )

#define LD2		LL_GPIO_PIN_4 //Puerto B
#define LD2_PORT           GPIOB
#define LD2_CLK_ENABLE()   LL_AHB2_GRP1_EnableClock(LL_AHB2_GRP1_PERIPH_GPIOB )

#define LD3		LL_GPIO_PIN_10 //Puerto B
#define LD3_PORT           GPIOB
#define LD3_CLK_ENABLE()   LL_AHB2_GRP1_EnableClock(LL_AHB2_GRP1_PERIPH_GPIOB )

#define LD4		LL_GPIO_PIN_8 //Puerto A
#define LD4_PORT           GPIOA
#define LD4_CLK_ENABLE()   LL_AHB2_GRP1_EnableClock(LL_AHB2_GRP1_PERIPH_GPIOA )

#define LD5		LL_GPIO_PIN_9 //Puerto A
#define LD5_PORT           GPIOA
#define LD5_CLK_ENABLE()   LL_AHB2_GRP1_EnableClock(LL_AHB2_GRP1_PERIPH_GPIOA )

#define LD6		LL_GPIO_PIN_9 //Puerto B
#define LD6_PORT           GPIOB
#define LD6_CLK_ENABLE()   LL_AHB2_GRP1_EnableClock(LL_AHB2_GRP1_PERIPH_GPIOB )

#define LD7		LL_GPIO_PIN_8 //Puerto B
#define LD7_PORT           GPIOB
#define LD7_CLK_ENABLE()   LL_AHB2_GRP1_EnableClock(LL_AHB2_GRP1_PERIPH_GPIOB )

#define S1		LL_GPIO_PIN_1 //Puerto A
#define S1_PORT           GPIOA
#define S1_CLK_ENABLE()   LL_AHB2_GRP1_EnableClock(LL_AHB2_GRP1_PERIPH_GPIOA )

#define S2	    LL_GPIO_PIN_4 //Puerto A
#define S2_PORT           GPIOA
#define S2_CLK_ENABLE()   LL_AHB2_GRP1_EnableClock(LL_AHB2_GRP1_PERIPH_GPIOA )

#define S3		LL_GPIO_PIN_0 //Puerto B
#define S3_PORT           GPIOB
#define S3_CLK_ENABLE()   LL_AHB2_GRP1_EnableClock(LL_AHB2_GRP1_PERIPH_GPIOB )



void HAL_NUCLEO_L476_INIT();

void LD0_Set(void);
void LD0_Reset(void);

void LD1_Set(void);
void LD1_Reset(void);

void LD2_Set(void);
void LD2_Reset(void);

void LD3_Set(void);
void LD3_Reset(void);

void LD4_Set(void);
void LD4_Reset(void);

void LD5_Set(void);
void LD5_Reset(void);

void LD6_Set(void);
void LD6_Reset(void);

void LD7_Set(void);
void LD7_Reset(void);

#endif /* INCLUDE_HAL_NUCLEO_L476_H_ */
