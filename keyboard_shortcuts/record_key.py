from record_key import get_controller
import time


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
    pair = None
    for word, convert in pairs.items():
        compare_str = "".join(log[-len(word):])
        if word != compare_str:
            continue
        match = word
        pair = convert
        break   
    
    if match is None:
        return
    
    ctrl = get_controller()
    ctrl.type("\b" * len(match))
    ctrl.type(pair)