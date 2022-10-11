################################################################################
# Automatically-generated file. Do not edit!
# Toolchain: GNU Tools for STM32 (10.3-2021.10)
################################################################################

# Add inputs and outputs from these tool invocations to the build variables 
S_SRCS += \
../Core/main.s \
../Core/main_h.s 

OBJS += \
./Core/main.o \
./Core/main_h.o 

S_DEPS += \
./Core/main.d \
./Core/main_h.d 


# Each subdirectory must supply rules for building sources it contributes
Core/%.o: ../Core/%.s Core/subdir.mk
	arm-none-eabi-gcc -mcpu=cortex-m4 -g3 -DDEBUG -c -I"C:/Users/gosor/STM32CubeIDE/Eval/Led_Sequence_Control_s/Drivers/STM32L476_MSP_ASM/Include" -I"C:/Users/gosor/STM32CubeIDE/Eval/Led_Sequence_Control_s/Drivers/STM32L476_BSP_N64_ASM/Include" -x assembler-with-cpp -MMD -MP -MF"$(@:%.o=%.d)" -MT"$@" --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -o "$@" "$<"

clean: clean-Core

clean-Core:
	-$(RM) ./Core/main.d ./Core/main.o ./Core/main_h.d ./Core/main_h.o

.PHONY: clean-Core

