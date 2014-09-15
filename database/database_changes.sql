alter table pitches add month varchar(4);
update pitches set month = substr(sv_id, 1, 4);
create index pitcher_index on atbats (pitcher);
create index month_index on pitches (month);
create index pitch_type on pitches(pitch_type);
