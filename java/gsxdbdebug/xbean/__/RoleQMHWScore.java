/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.util.HashMap;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import java.util.Set;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class RoleQMHWScore extends XBean implements xbean.RoleQMHWScore
/*      */ {
/*      */   private int score;
/*      */   private int wincount;
/*      */   private int losecount;
/*      */   private int continuewincount;
/*      */   private SetX<Integer> getawards;
/*      */   private SetX<Integer> getjoinawards;
/*      */   private HashMap<Long, Integer> matchroles;
/*      */   private int extendmatchscore;
/*      */   private SetX<Long> latestmatchroles;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.score = 0;
/*   35 */     this.wincount = 0;
/*   36 */     this.losecount = 0;
/*   37 */     this.continuewincount = 0;
/*   38 */     this.getawards.clear();
/*   39 */     this.getjoinawards.clear();
/*   40 */     this.matchroles.clear();
/*   41 */     this.extendmatchscore = 0;
/*   42 */     this.latestmatchroles.clear();
/*      */   }
/*      */   
/*      */   RoleQMHWScore(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.getawards = new SetX();
/*   49 */     this.getjoinawards = new SetX();
/*   50 */     this.matchroles = new HashMap();
/*   51 */     this.extendmatchscore = 0;
/*   52 */     this.latestmatchroles = new SetX();
/*      */   }
/*      */   
/*      */   public RoleQMHWScore()
/*      */   {
/*   57 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public RoleQMHWScore(RoleQMHWScore _o_)
/*      */   {
/*   62 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   RoleQMHWScore(xbean.RoleQMHWScore _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   67 */     super(_xp_, _vn_);
/*   68 */     if ((_o1_ instanceof RoleQMHWScore)) { assign((RoleQMHWScore)_o1_);
/*   69 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   70 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   71 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(RoleQMHWScore _o_) {
/*   76 */     _o_._xdb_verify_unsafe_();
/*   77 */     this.score = _o_.score;
/*   78 */     this.wincount = _o_.wincount;
/*   79 */     this.losecount = _o_.losecount;
/*   80 */     this.continuewincount = _o_.continuewincount;
/*   81 */     this.getawards = new SetX();
/*   82 */     this.getawards.addAll(_o_.getawards);
/*   83 */     this.getjoinawards = new SetX();
/*   84 */     this.getjoinawards.addAll(_o_.getjoinawards);
/*   85 */     this.matchroles = new HashMap();
/*   86 */     for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*   87 */       this.matchroles.put(_e_.getKey(), _e_.getValue());
/*   88 */     this.extendmatchscore = _o_.extendmatchscore;
/*   89 */     this.latestmatchroles = new SetX();
/*   90 */     this.latestmatchroles.addAll(_o_.latestmatchroles);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   95 */     this.score = _o_.score;
/*   96 */     this.wincount = _o_.wincount;
/*   97 */     this.losecount = _o_.losecount;
/*   98 */     this.continuewincount = _o_.continuewincount;
/*   99 */     this.getawards = new SetX();
/*  100 */     this.getawards.addAll(_o_.getawards);
/*  101 */     this.getjoinawards = new SetX();
/*  102 */     this.getjoinawards.addAll(_o_.getjoinawards);
/*  103 */     this.matchroles = new HashMap();
/*  104 */     for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*  105 */       this.matchroles.put(_e_.getKey(), _e_.getValue());
/*  106 */     this.extendmatchscore = _o_.extendmatchscore;
/*  107 */     this.latestmatchroles = new SetX();
/*  108 */     this.latestmatchroles.addAll(_o_.latestmatchroles);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  114 */     _xdb_verify_unsafe_();
/*  115 */     _os_.marshal(this.score);
/*  116 */     _os_.marshal(this.wincount);
/*  117 */     _os_.marshal(this.losecount);
/*  118 */     _os_.marshal(this.continuewincount);
/*  119 */     _os_.compact_uint32(this.getawards.size());
/*  120 */     for (Integer _v_ : this.getawards)
/*      */     {
/*  122 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  124 */     _os_.compact_uint32(this.getjoinawards.size());
/*  125 */     for (Integer _v_ : this.getjoinawards)
/*      */     {
/*  127 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  129 */     _os_.compact_uint32(this.matchroles.size());
/*  130 */     for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */     {
/*  132 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  133 */       _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */     }
/*  135 */     _os_.marshal(this.extendmatchscore);
/*  136 */     _os_.compact_uint32(this.latestmatchroles.size());
/*  137 */     for (Long _v_ : this.latestmatchroles)
/*      */     {
/*  139 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  141 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  147 */     _xdb_verify_unsafe_();
/*  148 */     this.score = _os_.unmarshal_int();
/*  149 */     this.wincount = _os_.unmarshal_int();
/*  150 */     this.losecount = _os_.unmarshal_int();
/*  151 */     this.continuewincount = _os_.unmarshal_int();
/*  152 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  154 */       int _v_ = 0;
/*  155 */       _v_ = _os_.unmarshal_int();
/*  156 */       this.getawards.add(Integer.valueOf(_v_));
/*      */     }
/*  158 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  160 */       int _v_ = 0;
/*  161 */       _v_ = _os_.unmarshal_int();
/*  162 */       this.getjoinawards.add(Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  165 */     int size = _os_.uncompact_uint32();
/*  166 */     if (size >= 12)
/*      */     {
/*  168 */       this.matchroles = new HashMap(size * 2);
/*      */     }
/*  170 */     for (; size > 0; size--)
/*      */     {
/*  172 */       long _k_ = 0L;
/*  173 */       _k_ = _os_.unmarshal_long();
/*  174 */       int _v_ = 0;
/*  175 */       _v_ = _os_.unmarshal_int();
/*  176 */       this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */     }
/*      */     
/*  179 */     this.extendmatchscore = _os_.unmarshal_int();
/*  180 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  182 */       long _v_ = 0L;
/*  183 */       _v_ = _os_.unmarshal_long();
/*  184 */       this.latestmatchroles.add(Long.valueOf(_v_));
/*      */     }
/*  186 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  192 */     _xdb_verify_unsafe_();
/*  193 */     int _size_ = 0;
/*  194 */     _size_ += CodedOutputStream.computeInt32Size(1, this.score);
/*  195 */     _size_ += CodedOutputStream.computeInt32Size(2, this.wincount);
/*  196 */     _size_ += CodedOutputStream.computeInt32Size(3, this.losecount);
/*  197 */     _size_ += CodedOutputStream.computeInt32Size(4, this.continuewincount);
/*  198 */     for (Integer _v_ : this.getawards)
/*      */     {
/*  200 */       _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */     }
/*  202 */     for (Integer _v_ : this.getjoinawards)
/*      */     {
/*  204 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  206 */     for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */     {
/*  208 */       _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/*  209 */       _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */     }
/*  211 */     _size_ += CodedOutputStream.computeInt32Size(9, this.extendmatchscore);
/*  212 */     for (Long _v_ : this.latestmatchroles)
/*      */     {
/*  214 */       _size_ += CodedOutputStream.computeInt64Size(10, _v_.longValue());
/*      */     }
/*  216 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  222 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  225 */       _output_.writeInt32(1, this.score);
/*  226 */       _output_.writeInt32(2, this.wincount);
/*  227 */       _output_.writeInt32(3, this.losecount);
/*  228 */       _output_.writeInt32(4, this.continuewincount);
/*  229 */       for (Integer _v_ : this.getawards)
/*      */       {
/*  231 */         _output_.writeInt32(5, _v_.intValue());
/*      */       }
/*  233 */       for (Integer _v_ : this.getjoinawards)
/*      */       {
/*  235 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*  237 */       for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */       {
/*  239 */         _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/*  240 */         _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/*  242 */       _output_.writeInt32(9, this.extendmatchscore);
/*  243 */       for (Long _v_ : this.latestmatchroles)
/*      */       {
/*  245 */         _output_.writeInt64(10, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  250 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  252 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  258 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  261 */       boolean done = false;
/*  262 */       while (!done)
/*      */       {
/*  264 */         int tag = _input_.readTag();
/*  265 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  269 */           done = true;
/*  270 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  274 */           this.score = _input_.readInt32();
/*  275 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  279 */           this.wincount = _input_.readInt32();
/*  280 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  284 */           this.losecount = _input_.readInt32();
/*  285 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  289 */           this.continuewincount = _input_.readInt32();
/*  290 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  294 */           int _v_ = 0;
/*  295 */           _v_ = _input_.readInt32();
/*  296 */           this.getawards.add(Integer.valueOf(_v_));
/*  297 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  301 */           int _v_ = 0;
/*  302 */           _v_ = _input_.readInt32();
/*  303 */           this.getjoinawards.add(Integer.valueOf(_v_));
/*  304 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  308 */           long _k_ = 0L;
/*  309 */           _k_ = _input_.readInt64();
/*  310 */           int readTag = _input_.readTag();
/*  311 */           if (56 != readTag)
/*      */           {
/*  313 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  315 */           int _v_ = 0;
/*  316 */           _v_ = _input_.readInt32();
/*  317 */           this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*  318 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  322 */           this.extendmatchscore = _input_.readInt32();
/*  323 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  327 */           long _v_ = 0L;
/*  328 */           _v_ = _input_.readInt64();
/*  329 */           this.latestmatchroles.add(Long.valueOf(_v_));
/*  330 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  334 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  336 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  345 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  349 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  351 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleQMHWScore copy()
/*      */   {
/*  357 */     _xdb_verify_unsafe_();
/*  358 */     return new RoleQMHWScore(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleQMHWScore toData()
/*      */   {
/*  364 */     _xdb_verify_unsafe_();
/*  365 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleQMHWScore toBean()
/*      */   {
/*  370 */     _xdb_verify_unsafe_();
/*  371 */     return new RoleQMHWScore(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.RoleQMHWScore toDataIf()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.RoleQMHWScore toBeanIf()
/*      */   {
/*  383 */     _xdb_verify_unsafe_();
/*  384 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  390 */     _xdb_verify_unsafe_();
/*  391 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getScore()
/*      */   {
/*  398 */     _xdb_verify_unsafe_();
/*  399 */     return this.score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWincount()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return this.wincount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLosecount()
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*  415 */     return this.losecount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getContinuewincount()
/*      */   {
/*  422 */     _xdb_verify_unsafe_();
/*  423 */     return this.continuewincount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getGetawards()
/*      */   {
/*  430 */     _xdb_verify_unsafe_();
/*  431 */     return Logs.logSet(new LogKey(this, "getawards"), this.getawards);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getGetawardsAsData()
/*      */   {
/*  437 */     _xdb_verify_unsafe_();
/*      */     
/*  439 */     RoleQMHWScore _o_ = this;
/*  440 */     Set<Integer> getawards = new SetX();
/*  441 */     getawards.addAll(_o_.getawards);
/*  442 */     return getawards;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getGetjoinawards()
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*  450 */     return Logs.logSet(new LogKey(this, "getjoinawards"), this.getjoinawards);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getGetjoinawardsAsData()
/*      */   {
/*  456 */     _xdb_verify_unsafe_();
/*      */     
/*  458 */     RoleQMHWScore _o_ = this;
/*  459 */     Set<Integer> getjoinawards = new SetX();
/*  460 */     getjoinawards.addAll(_o_.getjoinawards);
/*  461 */     return getjoinawards;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getMatchroles()
/*      */   {
/*  468 */     _xdb_verify_unsafe_();
/*  469 */     return Logs.logMap(new LogKey(this, "matchroles"), this.matchroles);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, Integer> getMatchrolesAsData()
/*      */   {
/*  476 */     _xdb_verify_unsafe_();
/*      */     
/*  478 */     RoleQMHWScore _o_ = this;
/*  479 */     Map<Long, Integer> matchroles = new HashMap();
/*  480 */     for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*  481 */       matchroles.put(_e_.getKey(), _e_.getValue());
/*  482 */     return matchroles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExtendmatchscore()
/*      */   {
/*  489 */     _xdb_verify_unsafe_();
/*  490 */     return this.extendmatchscore;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Long> getLatestmatchroles()
/*      */   {
/*  497 */     _xdb_verify_unsafe_();
/*  498 */     return Logs.logSet(new LogKey(this, "latestmatchroles"), this.latestmatchroles);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Long> getLatestmatchrolesAsData()
/*      */   {
/*  504 */     _xdb_verify_unsafe_();
/*      */     
/*  506 */     RoleQMHWScore _o_ = this;
/*  507 */     Set<Long> latestmatchroles = new SetX();
/*  508 */     latestmatchroles.addAll(_o_.latestmatchroles);
/*  509 */     return latestmatchroles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setScore(int _v_)
/*      */   {
/*  516 */     _xdb_verify_unsafe_();
/*  517 */     Logs.logIf(new LogKey(this, "score")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  521 */         new LogInt(this, RoleQMHWScore.this.score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  525 */             RoleQMHWScore.this.score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  529 */     });
/*  530 */     this.score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWincount(int _v_)
/*      */   {
/*  537 */     _xdb_verify_unsafe_();
/*  538 */     Logs.logIf(new LogKey(this, "wincount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  542 */         new LogInt(this, RoleQMHWScore.this.wincount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  546 */             RoleQMHWScore.this.wincount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  550 */     });
/*  551 */     this.wincount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLosecount(int _v_)
/*      */   {
/*  558 */     _xdb_verify_unsafe_();
/*  559 */     Logs.logIf(new LogKey(this, "losecount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  563 */         new LogInt(this, RoleQMHWScore.this.losecount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  567 */             RoleQMHWScore.this.losecount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  571 */     });
/*  572 */     this.losecount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setContinuewincount(int _v_)
/*      */   {
/*  579 */     _xdb_verify_unsafe_();
/*  580 */     Logs.logIf(new LogKey(this, "continuewincount")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  584 */         new LogInt(this, RoleQMHWScore.this.continuewincount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  588 */             RoleQMHWScore.this.continuewincount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  592 */     });
/*  593 */     this.continuewincount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExtendmatchscore(int _v_)
/*      */   {
/*  600 */     _xdb_verify_unsafe_();
/*  601 */     Logs.logIf(new LogKey(this, "extendmatchscore")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  605 */         new LogInt(this, RoleQMHWScore.this.extendmatchscore)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  609 */             RoleQMHWScore.this.extendmatchscore = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  613 */     });
/*  614 */     this.extendmatchscore = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  620 */     _xdb_verify_unsafe_();
/*  621 */     RoleQMHWScore _o_ = null;
/*  622 */     if ((_o1_ instanceof RoleQMHWScore)) { _o_ = (RoleQMHWScore)_o1_;
/*  623 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  624 */       return false;
/*  625 */     if (this.score != _o_.score) return false;
/*  626 */     if (this.wincount != _o_.wincount) return false;
/*  627 */     if (this.losecount != _o_.losecount) return false;
/*  628 */     if (this.continuewincount != _o_.continuewincount) return false;
/*  629 */     if (!this.getawards.equals(_o_.getawards)) return false;
/*  630 */     if (!this.getjoinawards.equals(_o_.getjoinawards)) return false;
/*  631 */     if (!this.matchroles.equals(_o_.matchroles)) return false;
/*  632 */     if (this.extendmatchscore != _o_.extendmatchscore) return false;
/*  633 */     if (!this.latestmatchroles.equals(_o_.latestmatchroles)) return false;
/*  634 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  640 */     _xdb_verify_unsafe_();
/*  641 */     int _h_ = 0;
/*  642 */     _h_ += this.score;
/*  643 */     _h_ += this.wincount;
/*  644 */     _h_ += this.losecount;
/*  645 */     _h_ += this.continuewincount;
/*  646 */     _h_ += this.getawards.hashCode();
/*  647 */     _h_ += this.getjoinawards.hashCode();
/*  648 */     _h_ += this.matchroles.hashCode();
/*  649 */     _h_ += this.extendmatchscore;
/*  650 */     _h_ += this.latestmatchroles.hashCode();
/*  651 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  657 */     _xdb_verify_unsafe_();
/*  658 */     StringBuilder _sb_ = new StringBuilder();
/*  659 */     _sb_.append("(");
/*  660 */     _sb_.append(this.score);
/*  661 */     _sb_.append(",");
/*  662 */     _sb_.append(this.wincount);
/*  663 */     _sb_.append(",");
/*  664 */     _sb_.append(this.losecount);
/*  665 */     _sb_.append(",");
/*  666 */     _sb_.append(this.continuewincount);
/*  667 */     _sb_.append(",");
/*  668 */     _sb_.append(this.getawards);
/*  669 */     _sb_.append(",");
/*  670 */     _sb_.append(this.getjoinawards);
/*  671 */     _sb_.append(",");
/*  672 */     _sb_.append(this.matchroles);
/*  673 */     _sb_.append(",");
/*  674 */     _sb_.append(this.extendmatchscore);
/*  675 */     _sb_.append(",");
/*  676 */     _sb_.append(this.latestmatchroles);
/*  677 */     _sb_.append(")");
/*  678 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  684 */     ListenableBean lb = new ListenableBean();
/*  685 */     lb.add(new ListenableChanged().setVarName("score"));
/*  686 */     lb.add(new ListenableChanged().setVarName("wincount"));
/*  687 */     lb.add(new ListenableChanged().setVarName("losecount"));
/*  688 */     lb.add(new ListenableChanged().setVarName("continuewincount"));
/*  689 */     lb.add(new xdb.logs.ListenableSet().setVarName("getawards"));
/*  690 */     lb.add(new xdb.logs.ListenableSet().setVarName("getjoinawards"));
/*  691 */     lb.add(new xdb.logs.ListenableMap().setVarName("matchroles"));
/*  692 */     lb.add(new ListenableChanged().setVarName("extendmatchscore"));
/*  693 */     lb.add(new xdb.logs.ListenableSet().setVarName("latestmatchroles"));
/*  694 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.RoleQMHWScore {
/*      */     private Const() {}
/*      */     
/*      */     RoleQMHWScore nThis() {
/*  701 */       return RoleQMHWScore.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  707 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleQMHWScore copy()
/*      */     {
/*  713 */       return RoleQMHWScore.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleQMHWScore toData()
/*      */     {
/*  719 */       return RoleQMHWScore.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.RoleQMHWScore toBean()
/*      */     {
/*  724 */       return RoleQMHWScore.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleQMHWScore toDataIf()
/*      */     {
/*  730 */       return RoleQMHWScore.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.RoleQMHWScore toBeanIf()
/*      */     {
/*  735 */       return RoleQMHWScore.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getScore()
/*      */     {
/*  742 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  743 */       return RoleQMHWScore.this.score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWincount()
/*      */     {
/*  750 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  751 */       return RoleQMHWScore.this.wincount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLosecount()
/*      */     {
/*  758 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  759 */       return RoleQMHWScore.this.losecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getContinuewincount()
/*      */     {
/*  766 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  767 */       return RoleQMHWScore.this.continuewincount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGetawards()
/*      */     {
/*  774 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  775 */       return xdb.Consts.constSet(RoleQMHWScore.this.getawards);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getGetawardsAsData()
/*      */     {
/*  781 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*      */       
/*  783 */       RoleQMHWScore _o_ = RoleQMHWScore.this;
/*  784 */       Set<Integer> getawards = new SetX();
/*  785 */       getawards.addAll(_o_.getawards);
/*  786 */       return getawards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGetjoinawards()
/*      */     {
/*  793 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  794 */       return xdb.Consts.constSet(RoleQMHWScore.this.getjoinawards);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getGetjoinawardsAsData()
/*      */     {
/*  800 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*      */       
/*  802 */       RoleQMHWScore _o_ = RoleQMHWScore.this;
/*  803 */       Set<Integer> getjoinawards = new SetX();
/*  804 */       getjoinawards.addAll(_o_.getjoinawards);
/*  805 */       return getjoinawards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchroles()
/*      */     {
/*  812 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  813 */       return xdb.Consts.constMap(RoleQMHWScore.this.matchroles);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchrolesAsData()
/*      */     {
/*  820 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*      */       
/*  822 */       RoleQMHWScore _o_ = RoleQMHWScore.this;
/*  823 */       Map<Long, Integer> matchroles = new HashMap();
/*  824 */       for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/*  825 */         matchroles.put(_e_.getKey(), _e_.getValue());
/*  826 */       return matchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExtendmatchscore()
/*      */     {
/*  833 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  834 */       return RoleQMHWScore.this.extendmatchscore;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getLatestmatchroles()
/*      */     {
/*  841 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  842 */       return xdb.Consts.constSet(RoleQMHWScore.this.latestmatchroles);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Long> getLatestmatchrolesAsData()
/*      */     {
/*  848 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*      */       
/*  850 */       RoleQMHWScore _o_ = RoleQMHWScore.this;
/*  851 */       Set<Long> latestmatchroles = new SetX();
/*  852 */       latestmatchroles.addAll(_o_.latestmatchroles);
/*  853 */       return latestmatchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setScore(int _v_)
/*      */     {
/*  860 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  861 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWincount(int _v_)
/*      */     {
/*  868 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  869 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLosecount(int _v_)
/*      */     {
/*  876 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  877 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setContinuewincount(int _v_)
/*      */     {
/*  884 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  885 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtendmatchscore(int _v_)
/*      */     {
/*  892 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  893 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  899 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  900 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  906 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  907 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  913 */       return RoleQMHWScore.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  919 */       return RoleQMHWScore.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  925 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  926 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  932 */       return RoleQMHWScore.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  938 */       return RoleQMHWScore.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  944 */       RoleQMHWScore.this._xdb_verify_unsafe_();
/*  945 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  951 */       return RoleQMHWScore.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  957 */       return RoleQMHWScore.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  963 */       return RoleQMHWScore.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  969 */       return RoleQMHWScore.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  975 */       return RoleQMHWScore.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  981 */       return RoleQMHWScore.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  987 */       return RoleQMHWScore.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.RoleQMHWScore
/*      */   {
/*      */     private int score;
/*      */     
/*      */     private int wincount;
/*      */     
/*      */     private int losecount;
/*      */     
/*      */     private int continuewincount;
/*      */     
/*      */     private HashSet<Integer> getawards;
/*      */     
/*      */     private HashSet<Integer> getjoinawards;
/*      */     
/*      */     private HashMap<Long, Integer> matchroles;
/*      */     
/*      */     private int extendmatchscore;
/*      */     
/*      */     private HashSet<Long> latestmatchroles;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1015 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1020 */       this.getawards = new HashSet();
/* 1021 */       this.getjoinawards = new HashSet();
/* 1022 */       this.matchroles = new HashMap();
/* 1023 */       this.extendmatchscore = 0;
/* 1024 */       this.latestmatchroles = new HashSet();
/*      */     }
/*      */     
/*      */     Data(xbean.RoleQMHWScore _o1_)
/*      */     {
/* 1029 */       if ((_o1_ instanceof RoleQMHWScore)) { assign((RoleQMHWScore)_o1_);
/* 1030 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1031 */       } else if ((_o1_ instanceof RoleQMHWScore.Const)) assign(((RoleQMHWScore.Const)_o1_).nThis()); else {
/* 1032 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(RoleQMHWScore _o_) {
/* 1037 */       this.score = _o_.score;
/* 1038 */       this.wincount = _o_.wincount;
/* 1039 */       this.losecount = _o_.losecount;
/* 1040 */       this.continuewincount = _o_.continuewincount;
/* 1041 */       this.getawards = new HashSet();
/* 1042 */       this.getawards.addAll(_o_.getawards);
/* 1043 */       this.getjoinawards = new HashSet();
/* 1044 */       this.getjoinawards.addAll(_o_.getjoinawards);
/* 1045 */       this.matchroles = new HashMap();
/* 1046 */       for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/* 1047 */         this.matchroles.put(_e_.getKey(), _e_.getValue());
/* 1048 */       this.extendmatchscore = _o_.extendmatchscore;
/* 1049 */       this.latestmatchroles = new HashSet();
/* 1050 */       this.latestmatchroles.addAll(_o_.latestmatchroles);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1055 */       this.score = _o_.score;
/* 1056 */       this.wincount = _o_.wincount;
/* 1057 */       this.losecount = _o_.losecount;
/* 1058 */       this.continuewincount = _o_.continuewincount;
/* 1059 */       this.getawards = new HashSet();
/* 1060 */       this.getawards.addAll(_o_.getawards);
/* 1061 */       this.getjoinawards = new HashSet();
/* 1062 */       this.getjoinawards.addAll(_o_.getjoinawards);
/* 1063 */       this.matchroles = new HashMap();
/* 1064 */       for (Map.Entry<Long, Integer> _e_ : _o_.matchroles.entrySet())
/* 1065 */         this.matchroles.put(_e_.getKey(), _e_.getValue());
/* 1066 */       this.extendmatchscore = _o_.extendmatchscore;
/* 1067 */       this.latestmatchroles = new HashSet();
/* 1068 */       this.latestmatchroles.addAll(_o_.latestmatchroles);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1074 */       _os_.marshal(this.score);
/* 1075 */       _os_.marshal(this.wincount);
/* 1076 */       _os_.marshal(this.losecount);
/* 1077 */       _os_.marshal(this.continuewincount);
/* 1078 */       _os_.compact_uint32(this.getawards.size());
/* 1079 */       for (Integer _v_ : this.getawards)
/*      */       {
/* 1081 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1083 */       _os_.compact_uint32(this.getjoinawards.size());
/* 1084 */       for (Integer _v_ : this.getjoinawards)
/*      */       {
/* 1086 */         _os_.marshal(_v_.intValue());
/*      */       }
/* 1088 */       _os_.compact_uint32(this.matchroles.size());
/* 1089 */       for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */       {
/* 1091 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/* 1092 */         _os_.marshal(((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1094 */       _os_.marshal(this.extendmatchscore);
/* 1095 */       _os_.compact_uint32(this.latestmatchroles.size());
/* 1096 */       for (Long _v_ : this.latestmatchroles)
/*      */       {
/* 1098 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1100 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1106 */       this.score = _os_.unmarshal_int();
/* 1107 */       this.wincount = _os_.unmarshal_int();
/* 1108 */       this.losecount = _os_.unmarshal_int();
/* 1109 */       this.continuewincount = _os_.unmarshal_int();
/* 1110 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1112 */         int _v_ = 0;
/* 1113 */         _v_ = _os_.unmarshal_int();
/* 1114 */         this.getawards.add(Integer.valueOf(_v_));
/*      */       }
/* 1116 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1118 */         int _v_ = 0;
/* 1119 */         _v_ = _os_.unmarshal_int();
/* 1120 */         this.getjoinawards.add(Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1123 */       int size = _os_.uncompact_uint32();
/* 1124 */       if (size >= 12)
/*      */       {
/* 1126 */         this.matchroles = new HashMap(size * 2);
/*      */       }
/* 1128 */       for (; size > 0; size--)
/*      */       {
/* 1130 */         long _k_ = 0L;
/* 1131 */         _k_ = _os_.unmarshal_long();
/* 1132 */         int _v_ = 0;
/* 1133 */         _v_ = _os_.unmarshal_int();
/* 1134 */         this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/*      */       }
/*      */       
/* 1137 */       this.extendmatchscore = _os_.unmarshal_int();
/* 1138 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1140 */         long _v_ = 0L;
/* 1141 */         _v_ = _os_.unmarshal_long();
/* 1142 */         this.latestmatchroles.add(Long.valueOf(_v_));
/*      */       }
/* 1144 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1150 */       int _size_ = 0;
/* 1151 */       _size_ += CodedOutputStream.computeInt32Size(1, this.score);
/* 1152 */       _size_ += CodedOutputStream.computeInt32Size(2, this.wincount);
/* 1153 */       _size_ += CodedOutputStream.computeInt32Size(3, this.losecount);
/* 1154 */       _size_ += CodedOutputStream.computeInt32Size(4, this.continuewincount);
/* 1155 */       for (Integer _v_ : this.getawards)
/*      */       {
/* 1157 */         _size_ += CodedOutputStream.computeInt32Size(5, _v_.intValue());
/*      */       }
/* 1159 */       for (Integer _v_ : this.getjoinawards)
/*      */       {
/* 1161 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/* 1163 */       for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */       {
/* 1165 */         _size_ += CodedOutputStream.computeInt64Size(7, ((Long)_e_.getKey()).longValue());
/* 1166 */         _size_ += CodedOutputStream.computeInt32Size(7, ((Integer)_e_.getValue()).intValue());
/*      */       }
/* 1168 */       _size_ += CodedOutputStream.computeInt32Size(9, this.extendmatchscore);
/* 1169 */       for (Long _v_ : this.latestmatchroles)
/*      */       {
/* 1171 */         _size_ += CodedOutputStream.computeInt64Size(10, _v_.longValue());
/*      */       }
/* 1173 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1181 */         _output_.writeInt32(1, this.score);
/* 1182 */         _output_.writeInt32(2, this.wincount);
/* 1183 */         _output_.writeInt32(3, this.losecount);
/* 1184 */         _output_.writeInt32(4, this.continuewincount);
/* 1185 */         for (Integer _v_ : this.getawards)
/*      */         {
/* 1187 */           _output_.writeInt32(5, _v_.intValue());
/*      */         }
/* 1189 */         for (Integer _v_ : this.getjoinawards)
/*      */         {
/* 1191 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/* 1193 */         for (Map.Entry<Long, Integer> _e_ : this.matchroles.entrySet())
/*      */         {
/* 1195 */           _output_.writeInt64(7, ((Long)_e_.getKey()).longValue());
/* 1196 */           _output_.writeInt32(7, ((Integer)_e_.getValue()).intValue());
/*      */         }
/* 1198 */         _output_.writeInt32(9, this.extendmatchscore);
/* 1199 */         for (Long _v_ : this.latestmatchroles)
/*      */         {
/* 1201 */           _output_.writeInt64(10, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1206 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1208 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1216 */         boolean done = false;
/* 1217 */         while (!done)
/*      */         {
/* 1219 */           int tag = _input_.readTag();
/* 1220 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1224 */             done = true;
/* 1225 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1229 */             this.score = _input_.readInt32();
/* 1230 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1234 */             this.wincount = _input_.readInt32();
/* 1235 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1239 */             this.losecount = _input_.readInt32();
/* 1240 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1244 */             this.continuewincount = _input_.readInt32();
/* 1245 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1249 */             int _v_ = 0;
/* 1250 */             _v_ = _input_.readInt32();
/* 1251 */             this.getawards.add(Integer.valueOf(_v_));
/* 1252 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1256 */             int _v_ = 0;
/* 1257 */             _v_ = _input_.readInt32();
/* 1258 */             this.getjoinawards.add(Integer.valueOf(_v_));
/* 1259 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1263 */             long _k_ = 0L;
/* 1264 */             _k_ = _input_.readInt64();
/* 1265 */             int readTag = _input_.readTag();
/* 1266 */             if (56 != readTag)
/*      */             {
/* 1268 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1270 */             int _v_ = 0;
/* 1271 */             _v_ = _input_.readInt32();
/* 1272 */             this.matchroles.put(Long.valueOf(_k_), Integer.valueOf(_v_));
/* 1273 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1277 */             this.extendmatchscore = _input_.readInt32();
/* 1278 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1282 */             long _v_ = 0L;
/* 1283 */             _v_ = _input_.readInt64();
/* 1284 */             this.latestmatchroles.add(Long.valueOf(_v_));
/* 1285 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1289 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1291 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1300 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1304 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1306 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleQMHWScore copy()
/*      */     {
/* 1312 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleQMHWScore toData()
/*      */     {
/* 1318 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.RoleQMHWScore toBean()
/*      */     {
/* 1323 */       return new RoleQMHWScore(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.RoleQMHWScore toDataIf()
/*      */     {
/* 1329 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.RoleQMHWScore toBeanIf()
/*      */     {
/* 1334 */       return new RoleQMHWScore(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1340 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1344 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1348 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1352 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1356 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1360 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1364 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getScore()
/*      */     {
/* 1371 */       return this.score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWincount()
/*      */     {
/* 1378 */       return this.wincount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLosecount()
/*      */     {
/* 1385 */       return this.losecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getContinuewincount()
/*      */     {
/* 1392 */       return this.continuewincount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGetawards()
/*      */     {
/* 1399 */       return this.getawards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGetawardsAsData()
/*      */     {
/* 1406 */       return this.getawards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGetjoinawards()
/*      */     {
/* 1413 */       return this.getjoinawards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getGetjoinawardsAsData()
/*      */     {
/* 1420 */       return this.getjoinawards;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchroles()
/*      */     {
/* 1427 */       return this.matchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, Integer> getMatchrolesAsData()
/*      */     {
/* 1434 */       return this.matchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExtendmatchscore()
/*      */     {
/* 1441 */       return this.extendmatchscore;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getLatestmatchroles()
/*      */     {
/* 1448 */       return this.latestmatchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Long> getLatestmatchrolesAsData()
/*      */     {
/* 1455 */       return this.latestmatchroles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setScore(int _v_)
/*      */     {
/* 1462 */       this.score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWincount(int _v_)
/*      */     {
/* 1469 */       this.wincount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLosecount(int _v_)
/*      */     {
/* 1476 */       this.losecount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setContinuewincount(int _v_)
/*      */     {
/* 1483 */       this.continuewincount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExtendmatchscore(int _v_)
/*      */     {
/* 1490 */       this.extendmatchscore = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1496 */       if (!(_o1_ instanceof Data)) return false;
/* 1497 */       Data _o_ = (Data)_o1_;
/* 1498 */       if (this.score != _o_.score) return false;
/* 1499 */       if (this.wincount != _o_.wincount) return false;
/* 1500 */       if (this.losecount != _o_.losecount) return false;
/* 1501 */       if (this.continuewincount != _o_.continuewincount) return false;
/* 1502 */       if (!this.getawards.equals(_o_.getawards)) return false;
/* 1503 */       if (!this.getjoinawards.equals(_o_.getjoinawards)) return false;
/* 1504 */       if (!this.matchroles.equals(_o_.matchroles)) return false;
/* 1505 */       if (this.extendmatchscore != _o_.extendmatchscore) return false;
/* 1506 */       if (!this.latestmatchroles.equals(_o_.latestmatchroles)) return false;
/* 1507 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1513 */       int _h_ = 0;
/* 1514 */       _h_ += this.score;
/* 1515 */       _h_ += this.wincount;
/* 1516 */       _h_ += this.losecount;
/* 1517 */       _h_ += this.continuewincount;
/* 1518 */       _h_ += this.getawards.hashCode();
/* 1519 */       _h_ += this.getjoinawards.hashCode();
/* 1520 */       _h_ += this.matchroles.hashCode();
/* 1521 */       _h_ += this.extendmatchscore;
/* 1522 */       _h_ += this.latestmatchroles.hashCode();
/* 1523 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1529 */       StringBuilder _sb_ = new StringBuilder();
/* 1530 */       _sb_.append("(");
/* 1531 */       _sb_.append(this.score);
/* 1532 */       _sb_.append(",");
/* 1533 */       _sb_.append(this.wincount);
/* 1534 */       _sb_.append(",");
/* 1535 */       _sb_.append(this.losecount);
/* 1536 */       _sb_.append(",");
/* 1537 */       _sb_.append(this.continuewincount);
/* 1538 */       _sb_.append(",");
/* 1539 */       _sb_.append(this.getawards);
/* 1540 */       _sb_.append(",");
/* 1541 */       _sb_.append(this.getjoinawards);
/* 1542 */       _sb_.append(",");
/* 1543 */       _sb_.append(this.matchroles);
/* 1544 */       _sb_.append(",");
/* 1545 */       _sb_.append(this.extendmatchscore);
/* 1546 */       _sb_.append(",");
/* 1547 */       _sb_.append(this.latestmatchroles);
/* 1548 */       _sb_.append(")");
/* 1549 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RoleQMHWScore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */