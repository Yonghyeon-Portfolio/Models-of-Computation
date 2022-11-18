from record_key import get_controller
import time

end_character = " "

def read_log():
    with open("log.txt", "r", encoding = "utf-8") as f:
        content = f.read().split("\n")
        content = "".join(content)
        return content[::-1]
    
def get_keywords(config_f):
    matches = dict()
    with open(config_f, "r", encoding="utf-8") as f:
        match_pairs = f.read().split("\n")
        for mp in match_pairs:
            if not mp.count(":") == 1:
                continue
            key, val = mp.split(":")
            key = key.strip(" ")
            val = val.strip(" ")
            matches[key] = val
    return matches
            
def write_if_match(pairs, log):
    match = None
    match_len = 0
    pair = None
    for p, val in pairs.items():
        if log.endswith(p + end_character) and len(p) > match_len:
            match = p
            match_len = len(p)
            pair = val
    
    if match is None:
        return
    
    ctrl = get_controller()
    ctrl.type("\b" * (len(match) + len(end_character)))
    ctrl.type(pair + " ")
