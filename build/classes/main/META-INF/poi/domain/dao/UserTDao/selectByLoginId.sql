select
  /*%expand*/*
from
  user_t
where
  username = /* loginId */'poi' and
  deleted_at is null