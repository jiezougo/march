  Alter table m_business modify `active` tinyint(1) NOT NULL DEFAULT '1';
  Alter table m_business modify `virtual` tinyint(1) NOT NULL DEFAULT '0';
  Alter table m_business modify `last_update` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP;