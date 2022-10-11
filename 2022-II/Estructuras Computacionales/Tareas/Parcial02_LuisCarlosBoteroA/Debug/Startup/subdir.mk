################################################################################
# Automatically-generated file. Do not edit!
# Toolchain: GNU Tools for STM32 (10.3-2021.10)
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
S_SRCS += \
../Startup/startup_stm32l476rgtx.s 

OBJS += \
./Startup/startup_stm32l476rgtx.o 

S_DEPS += \
./Startup/startup_stm32l476rgtx.d 


# Each subdirectory must supply rules for building sources it contributes
Startup/%.o: ../Startup/%.s Startup/subdir.mk
	arm-none-eabi-gcc -mcpu=cortex-m4 -g3 -DDEBUG -c -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Drivers/STM32L476_MSP_ASM/Include" -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Drivers/STM32L476_BSP_N64_ASM/Include" -I"C:/Users/nomei/OneDrive/Escritorio/Estructuras Comp/Led_Sequence_Control_s/Core/Include" -x assembler-with-cpp -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -o "$@" "$<"

clean: clean-Startup

clean-Startup:
	-$(RM) ./Startup/startup_stm32l476rgtx.d ./Startup/startup_stm32l476rgtx.o

.PHONY: clean-Startup

