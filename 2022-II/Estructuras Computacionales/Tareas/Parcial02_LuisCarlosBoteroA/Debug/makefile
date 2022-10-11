################################################################################
# Automatically-generated file. Do not edit!
# Toolchain: GNU Tools for STM32 (10.3-2021.10)
################################################################################

-include ../makefile.init

RM := rm -rf

# All of the sources participating in the build are defined here
-include sources.mk
-include Startup/subdir.mk
-include Drivers/STM32L476_MSP_ASM/Source/subdir.mk
-include Drivers/STM32L476_MSP_ASM/Include/subdir.mk
-include Drivers/STM32L476_BSP_N64_ASM/Source/subdir.mk
-include Drivers/STM32L476_BSP_N64_ASM/Include/subdir.mk
-include Core/Source/subdir.mk
-include Core/Include/subdir.mk
-include objects.mk

ifneq ($(MAKECMDGOALS),clean)
ifneq ($(strip $(S_DEPS)),)
-include $(S_DEPS)
endif
ifneq ($(strip $(S_UPPER_DEPS)),)
-include $(S_UPPER_DEPS)
endif
ifneq ($(strip $(C_DEPS)),)
-include $(C_DEPS)
endif
endif

-include ../makefile.defs

OPTIONAL_TOOL_DEPS := \
$(wildcard ../makefile.defs) \
$(wildcard ../makefile.init) \
$(wildcard ../makefile.targets) \


BUILD_ARTIFACT_NAME := Led_Sequence_Control_s
BUILD_ARTIFACT_EXTENSION := elf
BUILD_ARTIFACT_PREFIX :=
BUILD_ARTIFACT := $(BUILD_ARTIFACT_PREFIX)$(BUILD_ARTIFACT_NAME)$(if $(BUILD_ARTIFACT_EXTENSION),.$(BUILD_ARTIFACT_EXTENSION),)

# Add inputs and outputs from these tool invocations to the build variables 
EXECUTABLES += \
Led_Sequence_Control_s.elf \

MAP_FILES += \
Led_Sequence_Control_s.map \

SIZE_OUTPUT += \
default.size.stdout \

OBJDUMP_LIST += \
Led_Sequence_Control_s.list \


# All Target
all: main-build

# Main-build Target
main-build: Led_Sequence_Control_s.elf secondary-outputs

# Tool invocations
Led_Sequence_Control_s.elf Led_Sequence_Control_s.map: $(OBJS) $(USER_OBJS) C:\Users\nomei\OneDrive\Escritorio\Estructuras\ Comp\Led_Sequence_Control_s\STM32L476RGTX_FLASH.ld makefile objects.list $(OPTIONAL_TOOL_DEPS)
	arm-none-eabi-gcc -o "Led_Sequence_Control_s.elf" @"objects.list" $(USER_OBJS) $(LIBS) -mcpu=cortex-m4 -T"C:\Users\nomei\OneDrive\Escritorio\Estructuras Comp\Led_Sequence_Control_s\STM32L476RGTX_FLASH.ld" --specs=nosys.specs -Wl,-Map="Led_Sequence_Control_s.map" -Wl,--gc-sections -static --specs=nano.specs -mfpu=fpv4-sp-d16 -mfloat-abi=hard -mthumb -Wl,--start-group -lc -lm -Wl,--end-group
	@echo 'Finished building target: $@'
	@echo ' '

default.size.stdout: $(EXECUTABLES) makefile objects.list $(OPTIONAL_TOOL_DEPS)
	arm-none-eabi-size  $(EXECUTABLES)
	@echo 'Finished building: $@'
	@echo ' '

Led_Sequence_Control_s.list: $(EXECUTABLES) makefile objects.list $(OPTIONAL_TOOL_DEPS)
	arm-none-eabi-objdump -h -S $(EXECUTABLES) > "Led_Sequence_Control_s.list"
	@echo 'Finished building: $@'
	@echo ' '

# Other Targets
clean:
	-$(RM) Led_Sequence_Control_s.elf Led_Sequence_Control_s.list Led_Sequence_Control_s.map default.size.stdout
	-@echo ' '

secondary-outputs: $(SIZE_OUTPUT) $(OBJDUMP_LIST)

fail-specified-linker-script-missing:
	@echo 'Error: Cannot find the specified linker script. Check the linker settings in the build configuration.'
	@exit 2

warn-no-linker-script-specified:
	@echo 'Warning: No linker script specified. Check the linker settings in the build configuration.'

.PHONY: all clean dependents main-build fail-specified-linker-script-missing warn-no-linker-script-specified

-include ../makefile.targets
