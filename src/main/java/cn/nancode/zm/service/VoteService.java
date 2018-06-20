package cn.nancode.zm.service;

import cn.nancode.zm.dao.Vote;

public interface VoteService {

    Vote getVoteById(Long id);

    void removeVote(Long id);
}
