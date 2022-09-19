################################################################################
# Automatically-generated file. Do not edit!
# Toolchain: GNU Tools for STM32 (10.3-2021.10)
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
S_SRCS += \
../Drivers/STM32L4xx_DRV_ASM/Include/stm32l476_constants.s 

OBJS += \
./Drivers/STM32L4xx_DRV_ASM/Include/stm32l476_constants.o 

S_DEPS += \
./Drivers/STM32L4xx_DRV_ASM/Include/stm32l476_constants.d 


# Each subdirectory must supply rules for building sources it contributes
Drivers/STM32L4xx_DRV_ASM/Include/%.o: ../Drivers/STM32L4xx_DRV_ASM/Include/%.s Drivers/STM32L4xx_DRV_ASM/Include/subdir.mk
	arm-none-eabi-gcc -mcpu=cortex-m4 -g3 -DDEBUG -c -I"C:/Users/User/Desktop/GitHub/University/2022-II/Estructuras Computacionales/STM32_CubeIDE/02_Led_Blink_STKb_s/Drivers/STM32L4xx_DRV_ASM/Include" -x assembler-with-cpp -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -o "$@" "$<"

clean: clean-Drivers-2f-STM32L4xx_DRV_ASM-2f-Include

clean-Drivers-2f-STM32L4xx_DRV_ASM-2f-Include:
	-$(RM) ./Drivers/STM32L4xx_DRV_ASM/Include/stm32l476_constants.d ./Drivers/STM32L4xx_DRV_ASM/Include/stm32l476_constants.o

.PHONY: clean-Drivers-2f-STM32L4xx_DRV_ASM-2f-Include

