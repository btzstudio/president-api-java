package tech.btzstudio.president.auth.player;

import java.lang.annotation.*;

@Target ({ ElementType.METHOD})
@Retention (RetentionPolicy.RUNTIME)
public @interface PlayerRestricted
{
}
