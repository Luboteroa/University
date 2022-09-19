################################################################################
# Automatically-generated file. Do not edit!
# Toolchain: GNU Tools for STM32 (10.3-2021.10)
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
S_SRCS += \
../Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_SysTick.s \
../Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_gpio.s \
../Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_rcc.s 

OBJS += \
./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_SysTick.o \
./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_gpio.o \
./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_rcc.o 

S_DEPS += \
./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_SysTick.d \
./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_gpio.d \
./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_rcc.d 


# Each subdirectory must supply rules for building sources it contributes
Drivers/STM32L4xx_DRV_ASM/Source/%.o: ../Drivers/STM32L4xx_DRV_ASM/Source/%.s Drivers/STM32L4xx_DRV_ASM/Source/subdir.mk
	arm-none-eabi-gcc -mcpu=cortex-m4 -g3 -DDEBUG -c -I"C:/Users/User/Desktop/GitHub/University/2022-II/Estructuras Computacionales/STM32_CubeIDE/02_Led_Blink_STKb_s/Drivers/STM32L4xx_DRV_ASM/Include" -x assembler-with-cpp -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -o "$@" "$<"

clean: clean-Drivers-2f-STM32L4xx_DRV_ASM-2f-Source

clean-Drivers-2f-STM32L4xx_DRV_ASM-2f-Source:
	-$(RM) ./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_SysTick.d ./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_SysTick.o ./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_gpio.d ./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_gpio.o ./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_rcc.d ./Drivers/STM32L4xx_DRV_ASM/Source/stm32l476_drv_rcc.o

.PHONY: clean-Drivers-2f-STM32L4xx_DRV_ASM-2f-Source

