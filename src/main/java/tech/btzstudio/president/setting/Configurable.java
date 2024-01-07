package tech.btzstudio.president.setting;

import tech.btzstudio.president.setting.domain.GameSettings;

public interface Configurable {
    GameSettings override (GameSettings currentSettings);
}
