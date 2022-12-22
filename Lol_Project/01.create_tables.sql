CREATE SCHEMA IF NOT EXISTS `lol` DEFAULT CHARACTER SET utf8 ;
USE `lol` ;

-- -----------------------------------------------------
-- Table `lol`.`champion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lol`.`champion` (
  `champ_name` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`champ_name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lol`.`game`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lol`.`game` (
  `game_id` INT NOT NULL AUTO_INCREMENT,
  `start_time` DATETIME NOT NULL,
  `end_time` DATETIME NOT NULL,
  PRIMARY KEY (`game_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lol`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lol`.`user` (
  `user_id` VARCHAR(45) NOT NULL,
  `nickname` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `level` INT NOT NULL,
  `rank` VARCHAR(45) NULL DEFAULT NULL,
  `last_played` DATETIME NULL,
  PRIMARY KEY (`user_id`, `nickname`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `lol`.`game_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `lol`.`game_history` (
  `history_id` INT NOT NULL AUTO_INCREMENT,
  `game_id` INT NOT NULL,
  `user_id` VARCHAR(45) NOT NULL,
  `champ_name` VARCHAR(45) NOT NULL,
  `team` CHAR NOT NULL,
  `victory` TINYINT NULL,
  PRIMARY KEY (`history_id`),
  INDEX `fk_Game_copy1_has_Players_Players1_idx` (`user_id` ASC) VISIBLE,
  INDEX `fk_Game_copy1_has_Players_Game_copy11_idx` (`game_id` ASC) VISIBLE,
  INDEX `champ_name_idx` (`champ_name` ASC) VISIBLE,
  CONSTRAINT `champ_name`
    FOREIGN KEY (`champ_name`)
    REFERENCES `lol`.`champion` (`champ_name`),
  CONSTRAINT `game_id`
    FOREIGN KEY (`game_id`)
    REFERENCES `lol`.`game` (`game_id`),
  CONSTRAINT `player_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `lol`.`user` (`user_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;