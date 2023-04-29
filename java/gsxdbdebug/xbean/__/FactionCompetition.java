/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
/*      */ import xdb.Consts;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.Listenable;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ public final class FactionCompetition
/*      */   extends XBean implements xbean.FactionCompetition
/*      */ {
/*      */   private int elo_rank;
/*      */   private int pk_score;
/*      */   private int player_score;
/*      */   private boolean participated;
/*      */   private long opponent;
/*      */   private int win_times;
/*      */   private int lose_times;
/*      */   private int active_number;
/*      */   private int last_active_number;
/*      */   private long active_timestamp;
/*      */   private int mercenary_score;
/*      */   private int paticipate_count;
/*      */   private int last_partcipate_count;
/*      */   private ArrayList<Long> participate_roles;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   44 */     this.elo_rank = 0;
/*   45 */     this.pk_score = 0;
/*   46 */     this.player_score = 0;
/*   47 */     this.participated = false;
/*   48 */     this.opponent = -1L;
/*   49 */     this.win_times = 0;
/*   50 */     this.lose_times = 0;
/*   51 */     this.active_number = 0;
/*   52 */     this.last_active_number = 0;
/*   53 */     this.active_timestamp = 0L;
/*   54 */     this.mercenary_score = 0;
/*   55 */     this.paticipate_count = 0;
/*   56 */     this.last_partcipate_count = 0;
/*   57 */     this.participate_roles.clear();
/*      */   }
/*      */   
/*      */   FactionCompetition(int __, XBean _xp_, String _vn_)
/*      */   {
/*   62 */     super(_xp_, _vn_);
/*   63 */     this.elo_rank = 0;
/*   64 */     this.pk_score = 0;
/*   65 */     this.player_score = 0;
/*   66 */     this.participated = false;
/*   67 */     this.opponent = -1L;
/*   68 */     this.win_times = 0;
/*   69 */     this.lose_times = 0;
/*   70 */     this.active_number = 0;
/*   71 */     this.last_active_number = 0;
/*   72 */     this.active_timestamp = 0L;
/*   73 */     this.mercenary_score = 0;
/*   74 */     this.paticipate_count = 0;
/*   75 */     this.last_partcipate_count = 0;
/*   76 */     this.participate_roles = new ArrayList();
/*      */   }
/*      */   
/*      */   public FactionCompetition()
/*      */   {
/*   81 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FactionCompetition(FactionCompetition _o_)
/*      */   {
/*   86 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FactionCompetition(xbean.FactionCompetition _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   91 */     super(_xp_, _vn_);
/*   92 */     if ((_o1_ instanceof FactionCompetition)) { assign((FactionCompetition)_o1_);
/*   93 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   94 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   95 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FactionCompetition _o_) {
/*  100 */     _o_._xdb_verify_unsafe_();
/*  101 */     this.elo_rank = _o_.elo_rank;
/*  102 */     this.pk_score = _o_.pk_score;
/*  103 */     this.player_score = _o_.player_score;
/*  104 */     this.participated = _o_.participated;
/*  105 */     this.opponent = _o_.opponent;
/*  106 */     this.win_times = _o_.win_times;
/*  107 */     this.lose_times = _o_.lose_times;
/*  108 */     this.active_number = _o_.active_number;
/*  109 */     this.last_active_number = _o_.last_active_number;
/*  110 */     this.active_timestamp = _o_.active_timestamp;
/*  111 */     this.mercenary_score = _o_.mercenary_score;
/*  112 */     this.paticipate_count = _o_.paticipate_count;
/*  113 */     this.last_partcipate_count = _o_.last_partcipate_count;
/*  114 */     this.participate_roles = new ArrayList();
/*  115 */     this.participate_roles.addAll(_o_.participate_roles);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*  120 */     this.elo_rank = _o_.elo_rank;
/*  121 */     this.pk_score = _o_.pk_score;
/*  122 */     this.player_score = _o_.player_score;
/*  123 */     this.participated = _o_.participated;
/*  124 */     this.opponent = _o_.opponent;
/*  125 */     this.win_times = _o_.win_times;
/*  126 */     this.lose_times = _o_.lose_times;
/*  127 */     this.active_number = _o_.active_number;
/*  128 */     this.last_active_number = _o_.last_active_number;
/*  129 */     this.active_timestamp = _o_.active_timestamp;
/*  130 */     this.mercenary_score = _o_.mercenary_score;
/*  131 */     this.paticipate_count = _o_.paticipate_count;
/*  132 */     this.last_partcipate_count = _o_.last_partcipate_count;
/*  133 */     this.participate_roles = new ArrayList();
/*  134 */     this.participate_roles.addAll(_o_.participate_roles);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  140 */     _xdb_verify_unsafe_();
/*  141 */     _os_.marshal(this.elo_rank);
/*  142 */     _os_.marshal(this.pk_score);
/*  143 */     _os_.marshal(this.player_score);
/*  144 */     _os_.marshal(this.participated);
/*  145 */     _os_.marshal(this.opponent);
/*  146 */     _os_.marshal(this.win_times);
/*  147 */     _os_.marshal(this.lose_times);
/*  148 */     _os_.marshal(this.active_number);
/*  149 */     _os_.marshal(this.last_active_number);
/*  150 */     _os_.marshal(this.active_timestamp);
/*  151 */     _os_.marshal(this.mercenary_score);
/*  152 */     _os_.marshal(this.paticipate_count);
/*  153 */     _os_.marshal(this.last_partcipate_count);
/*  154 */     _os_.compact_uint32(this.participate_roles.size());
/*  155 */     for (Long _v_ : this.participate_roles)
/*      */     {
/*  157 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  159 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  165 */     _xdb_verify_unsafe_();
/*  166 */     this.elo_rank = _os_.unmarshal_int();
/*  167 */     this.pk_score = _os_.unmarshal_int();
/*  168 */     this.player_score = _os_.unmarshal_int();
/*  169 */     this.participated = _os_.unmarshal_boolean();
/*  170 */     this.opponent = _os_.unmarshal_long();
/*  171 */     this.win_times = _os_.unmarshal_int();
/*  172 */     this.lose_times = _os_.unmarshal_int();
/*  173 */     this.active_number = _os_.unmarshal_int();
/*  174 */     this.last_active_number = _os_.unmarshal_int();
/*  175 */     this.active_timestamp = _os_.unmarshal_long();
/*  176 */     this.mercenary_score = _os_.unmarshal_int();
/*  177 */     this.paticipate_count = _os_.unmarshal_int();
/*  178 */     this.last_partcipate_count = _os_.unmarshal_int();
/*  179 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  181 */       long _v_ = 0L;
/*  182 */       _v_ = _os_.unmarshal_long();
/*  183 */       this.participate_roles.add(Long.valueOf(_v_));
/*      */     }
/*  185 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  191 */     _xdb_verify_unsafe_();
/*  192 */     int _size_ = 0;
/*  193 */     _size_ += CodedOutputStream.computeInt32Size(1, this.elo_rank);
/*  194 */     _size_ += CodedOutputStream.computeInt32Size(2, this.pk_score);
/*  195 */     _size_ += CodedOutputStream.computeInt32Size(3, this.player_score);
/*  196 */     _size_ += CodedOutputStream.computeBoolSize(4, this.participated);
/*  197 */     _size_ += CodedOutputStream.computeInt64Size(5, this.opponent);
/*  198 */     _size_ += CodedOutputStream.computeInt32Size(6, this.win_times);
/*  199 */     _size_ += CodedOutputStream.computeInt32Size(7, this.lose_times);
/*  200 */     _size_ += CodedOutputStream.computeInt32Size(8, this.active_number);
/*  201 */     _size_ += CodedOutputStream.computeInt32Size(9, this.last_active_number);
/*  202 */     _size_ += CodedOutputStream.computeInt64Size(10, this.active_timestamp);
/*  203 */     _size_ += CodedOutputStream.computeInt32Size(11, this.mercenary_score);
/*  204 */     _size_ += CodedOutputStream.computeInt32Size(12, this.paticipate_count);
/*  205 */     _size_ += CodedOutputStream.computeInt32Size(13, this.last_partcipate_count);
/*  206 */     for (Long _v_ : this.participate_roles)
/*      */     {
/*  208 */       _size_ += CodedOutputStream.computeInt64Size(14, _v_.longValue());
/*      */     }
/*  210 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  216 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  219 */       _output_.writeInt32(1, this.elo_rank);
/*  220 */       _output_.writeInt32(2, this.pk_score);
/*  221 */       _output_.writeInt32(3, this.player_score);
/*  222 */       _output_.writeBool(4, this.participated);
/*  223 */       _output_.writeInt64(5, this.opponent);
/*  224 */       _output_.writeInt32(6, this.win_times);
/*  225 */       _output_.writeInt32(7, this.lose_times);
/*  226 */       _output_.writeInt32(8, this.active_number);
/*  227 */       _output_.writeInt32(9, this.last_active_number);
/*  228 */       _output_.writeInt64(10, this.active_timestamp);
/*  229 */       _output_.writeInt32(11, this.mercenary_score);
/*  230 */       _output_.writeInt32(12, this.paticipate_count);
/*  231 */       _output_.writeInt32(13, this.last_partcipate_count);
/*  232 */       for (Long _v_ : this.participate_roles)
/*      */       {
/*  234 */         _output_.writeInt64(14, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  239 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  241 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  250 */       boolean done = false;
/*  251 */       while (!done)
/*      */       {
/*  253 */         int tag = _input_.readTag();
/*  254 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  258 */           done = true;
/*  259 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  263 */           this.elo_rank = _input_.readInt32();
/*  264 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  268 */           this.pk_score = _input_.readInt32();
/*  269 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  273 */           this.player_score = _input_.readInt32();
/*  274 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  278 */           this.participated = _input_.readBool();
/*  279 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  283 */           this.opponent = _input_.readInt64();
/*  284 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  288 */           this.win_times = _input_.readInt32();
/*  289 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  293 */           this.lose_times = _input_.readInt32();
/*  294 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  298 */           this.active_number = _input_.readInt32();
/*  299 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  303 */           this.last_active_number = _input_.readInt32();
/*  304 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  308 */           this.active_timestamp = _input_.readInt64();
/*  309 */           break;
/*      */         
/*      */ 
/*      */         case 88: 
/*  313 */           this.mercenary_score = _input_.readInt32();
/*  314 */           break;
/*      */         
/*      */ 
/*      */         case 96: 
/*  318 */           this.paticipate_count = _input_.readInt32();
/*  319 */           break;
/*      */         
/*      */ 
/*      */         case 104: 
/*  323 */           this.last_partcipate_count = _input_.readInt32();
/*  324 */           break;
/*      */         
/*      */ 
/*      */         case 112: 
/*  328 */           long _v_ = 0L;
/*  329 */           _v_ = _input_.readInt64();
/*  330 */           this.participate_roles.add(Long.valueOf(_v_));
/*  331 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  335 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  337 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  346 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  350 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  352 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionCompetition copy()
/*      */   {
/*  358 */     _xdb_verify_unsafe_();
/*  359 */     return new FactionCompetition(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionCompetition toData()
/*      */   {
/*  365 */     _xdb_verify_unsafe_();
/*  366 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FactionCompetition toBean()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     return new FactionCompetition(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FactionCompetition toDataIf()
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FactionCompetition toBeanIf()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*  392 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getElo_rank()
/*      */   {
/*  399 */     _xdb_verify_unsafe_();
/*  400 */     return this.elo_rank;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPk_score()
/*      */   {
/*  407 */     _xdb_verify_unsafe_();
/*  408 */     return this.pk_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPlayer_score()
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     return this.player_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getParticipated()
/*      */   {
/*  423 */     _xdb_verify_unsafe_();
/*  424 */     return this.participated;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getOpponent()
/*      */   {
/*  431 */     _xdb_verify_unsafe_();
/*  432 */     return this.opponent;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getWin_times()
/*      */   {
/*  439 */     _xdb_verify_unsafe_();
/*  440 */     return this.win_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLose_times()
/*      */   {
/*  447 */     _xdb_verify_unsafe_();
/*  448 */     return this.lose_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getActive_number()
/*      */   {
/*  455 */     _xdb_verify_unsafe_();
/*  456 */     return this.active_number;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLast_active_number()
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*  464 */     return this.last_active_number;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getActive_timestamp()
/*      */   {
/*  471 */     _xdb_verify_unsafe_();
/*  472 */     return this.active_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getMercenary_score()
/*      */   {
/*  479 */     _xdb_verify_unsafe_();
/*  480 */     return this.mercenary_score;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPaticipate_count()
/*      */   {
/*  487 */     _xdb_verify_unsafe_();
/*  488 */     return this.paticipate_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getLast_partcipate_count()
/*      */   {
/*  495 */     _xdb_verify_unsafe_();
/*  496 */     return this.last_partcipate_count;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getParticipate_roles()
/*      */   {
/*  503 */     _xdb_verify_unsafe_();
/*  504 */     return Logs.logList(new LogKey(this, "participate_roles"), this.participate_roles);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getParticipate_rolesAsData()
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*      */     
/*  512 */     FactionCompetition _o_ = this;
/*  513 */     List<Long> participate_roles = new ArrayList();
/*  514 */     participate_roles.addAll(_o_.participate_roles);
/*  515 */     return participate_roles;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setElo_rank(int _v_)
/*      */   {
/*  522 */     _xdb_verify_unsafe_();
/*  523 */     Logs.logIf(new LogKey(this, "elo_rank")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  527 */         new LogInt(this, FactionCompetition.this.elo_rank)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  531 */             FactionCompetition.this.elo_rank = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  535 */     });
/*  536 */     this.elo_rank = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPk_score(int _v_)
/*      */   {
/*  543 */     _xdb_verify_unsafe_();
/*  544 */     Logs.logIf(new LogKey(this, "pk_score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  548 */         new LogInt(this, FactionCompetition.this.pk_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  552 */             FactionCompetition.this.pk_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  556 */     });
/*  557 */     this.pk_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPlayer_score(int _v_)
/*      */   {
/*  564 */     _xdb_verify_unsafe_();
/*  565 */     Logs.logIf(new LogKey(this, "player_score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  569 */         new LogInt(this, FactionCompetition.this.player_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  573 */             FactionCompetition.this.player_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  577 */     });
/*  578 */     this.player_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setParticipated(boolean _v_)
/*      */   {
/*  585 */     _xdb_verify_unsafe_();
/*  586 */     Logs.logIf(new LogKey(this, "participated")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  590 */         new LogObject(this, Boolean.valueOf(FactionCompetition.this.participated))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  594 */             FactionCompetition.this.participated = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  598 */     });
/*  599 */     this.participated = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setOpponent(long _v_)
/*      */   {
/*  606 */     _xdb_verify_unsafe_();
/*  607 */     Logs.logIf(new LogKey(this, "opponent")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  611 */         new LogLong(this, FactionCompetition.this.opponent)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  615 */             FactionCompetition.this.opponent = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  619 */     });
/*  620 */     this.opponent = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWin_times(int _v_)
/*      */   {
/*  627 */     _xdb_verify_unsafe_();
/*  628 */     Logs.logIf(new LogKey(this, "win_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  632 */         new LogInt(this, FactionCompetition.this.win_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  636 */             FactionCompetition.this.win_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  640 */     });
/*  641 */     this.win_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLose_times(int _v_)
/*      */   {
/*  648 */     _xdb_verify_unsafe_();
/*  649 */     Logs.logIf(new LogKey(this, "lose_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  653 */         new LogInt(this, FactionCompetition.this.lose_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  657 */             FactionCompetition.this.lose_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  661 */     });
/*  662 */     this.lose_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActive_number(int _v_)
/*      */   {
/*  669 */     _xdb_verify_unsafe_();
/*  670 */     Logs.logIf(new LogKey(this, "active_number")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  674 */         new LogInt(this, FactionCompetition.this.active_number)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  678 */             FactionCompetition.this.active_number = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  682 */     });
/*  683 */     this.active_number = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_active_number(int _v_)
/*      */   {
/*  690 */     _xdb_verify_unsafe_();
/*  691 */     Logs.logIf(new LogKey(this, "last_active_number")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  695 */         new LogInt(this, FactionCompetition.this.last_active_number)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  699 */             FactionCompetition.this.last_active_number = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  703 */     });
/*  704 */     this.last_active_number = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setActive_timestamp(long _v_)
/*      */   {
/*  711 */     _xdb_verify_unsafe_();
/*  712 */     Logs.logIf(new LogKey(this, "active_timestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  716 */         new LogLong(this, FactionCompetition.this.active_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  720 */             FactionCompetition.this.active_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  724 */     });
/*  725 */     this.active_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMercenary_score(int _v_)
/*      */   {
/*  732 */     _xdb_verify_unsafe_();
/*  733 */     Logs.logIf(new LogKey(this, "mercenary_score")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  737 */         new LogInt(this, FactionCompetition.this.mercenary_score)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  741 */             FactionCompetition.this.mercenary_score = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  745 */     });
/*  746 */     this.mercenary_score = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPaticipate_count(int _v_)
/*      */   {
/*  753 */     _xdb_verify_unsafe_();
/*  754 */     Logs.logIf(new LogKey(this, "paticipate_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  758 */         new LogInt(this, FactionCompetition.this.paticipate_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  762 */             FactionCompetition.this.paticipate_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  766 */     });
/*  767 */     this.paticipate_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_partcipate_count(int _v_)
/*      */   {
/*  774 */     _xdb_verify_unsafe_();
/*  775 */     Logs.logIf(new LogKey(this, "last_partcipate_count")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  779 */         new LogInt(this, FactionCompetition.this.last_partcipate_count)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  783 */             FactionCompetition.this.last_partcipate_count = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  787 */     });
/*  788 */     this.last_partcipate_count = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  794 */     _xdb_verify_unsafe_();
/*  795 */     FactionCompetition _o_ = null;
/*  796 */     if ((_o1_ instanceof FactionCompetition)) { _o_ = (FactionCompetition)_o1_;
/*  797 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  798 */       return false;
/*  799 */     if (this.elo_rank != _o_.elo_rank) return false;
/*  800 */     if (this.pk_score != _o_.pk_score) return false;
/*  801 */     if (this.player_score != _o_.player_score) return false;
/*  802 */     if (this.participated != _o_.participated) return false;
/*  803 */     if (this.opponent != _o_.opponent) return false;
/*  804 */     if (this.win_times != _o_.win_times) return false;
/*  805 */     if (this.lose_times != _o_.lose_times) return false;
/*  806 */     if (this.active_number != _o_.active_number) return false;
/*  807 */     if (this.last_active_number != _o_.last_active_number) return false;
/*  808 */     if (this.active_timestamp != _o_.active_timestamp) return false;
/*  809 */     if (this.mercenary_score != _o_.mercenary_score) return false;
/*  810 */     if (this.paticipate_count != _o_.paticipate_count) return false;
/*  811 */     if (this.last_partcipate_count != _o_.last_partcipate_count) return false;
/*  812 */     if (!this.participate_roles.equals(_o_.participate_roles)) return false;
/*  813 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  819 */     _xdb_verify_unsafe_();
/*  820 */     int _h_ = 0;
/*  821 */     _h_ += this.elo_rank;
/*  822 */     _h_ += this.pk_score;
/*  823 */     _h_ += this.player_score;
/*  824 */     _h_ += (this.participated ? 1231 : 1237);
/*  825 */     _h_ = (int)(_h_ + this.opponent);
/*  826 */     _h_ += this.win_times;
/*  827 */     _h_ += this.lose_times;
/*  828 */     _h_ += this.active_number;
/*  829 */     _h_ += this.last_active_number;
/*  830 */     _h_ = (int)(_h_ + this.active_timestamp);
/*  831 */     _h_ += this.mercenary_score;
/*  832 */     _h_ += this.paticipate_count;
/*  833 */     _h_ += this.last_partcipate_count;
/*  834 */     _h_ += this.participate_roles.hashCode();
/*  835 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  841 */     _xdb_verify_unsafe_();
/*  842 */     StringBuilder _sb_ = new StringBuilder();
/*  843 */     _sb_.append("(");
/*  844 */     _sb_.append(this.elo_rank);
/*  845 */     _sb_.append(",");
/*  846 */     _sb_.append(this.pk_score);
/*  847 */     _sb_.append(",");
/*  848 */     _sb_.append(this.player_score);
/*  849 */     _sb_.append(",");
/*  850 */     _sb_.append(this.participated);
/*  851 */     _sb_.append(",");
/*  852 */     _sb_.append(this.opponent);
/*  853 */     _sb_.append(",");
/*  854 */     _sb_.append(this.win_times);
/*  855 */     _sb_.append(",");
/*  856 */     _sb_.append(this.lose_times);
/*  857 */     _sb_.append(",");
/*  858 */     _sb_.append(this.active_number);
/*  859 */     _sb_.append(",");
/*  860 */     _sb_.append(this.last_active_number);
/*  861 */     _sb_.append(",");
/*  862 */     _sb_.append(this.active_timestamp);
/*  863 */     _sb_.append(",");
/*  864 */     _sb_.append(this.mercenary_score);
/*  865 */     _sb_.append(",");
/*  866 */     _sb_.append(this.paticipate_count);
/*  867 */     _sb_.append(",");
/*  868 */     _sb_.append(this.last_partcipate_count);
/*  869 */     _sb_.append(",");
/*  870 */     _sb_.append(this.participate_roles);
/*  871 */     _sb_.append(")");
/*  872 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/*  878 */     ListenableBean lb = new ListenableBean();
/*  879 */     lb.add(new ListenableChanged().setVarName("elo_rank"));
/*  880 */     lb.add(new ListenableChanged().setVarName("pk_score"));
/*  881 */     lb.add(new ListenableChanged().setVarName("player_score"));
/*  882 */     lb.add(new ListenableChanged().setVarName("participated"));
/*  883 */     lb.add(new ListenableChanged().setVarName("opponent"));
/*  884 */     lb.add(new ListenableChanged().setVarName("win_times"));
/*  885 */     lb.add(new ListenableChanged().setVarName("lose_times"));
/*  886 */     lb.add(new ListenableChanged().setVarName("active_number"));
/*  887 */     lb.add(new ListenableChanged().setVarName("last_active_number"));
/*  888 */     lb.add(new ListenableChanged().setVarName("active_timestamp"));
/*  889 */     lb.add(new ListenableChanged().setVarName("mercenary_score"));
/*  890 */     lb.add(new ListenableChanged().setVarName("paticipate_count"));
/*  891 */     lb.add(new ListenableChanged().setVarName("last_partcipate_count"));
/*  892 */     lb.add(new ListenableChanged().setVarName("participate_roles"));
/*  893 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FactionCompetition {
/*      */     private Const() {}
/*      */     
/*      */     FactionCompetition nThis() {
/*  900 */       return FactionCompetition.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  906 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCompetition copy()
/*      */     {
/*  912 */       return FactionCompetition.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCompetition toData()
/*      */     {
/*  918 */       return FactionCompetition.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FactionCompetition toBean()
/*      */     {
/*  923 */       return FactionCompetition.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCompetition toDataIf()
/*      */     {
/*  929 */       return FactionCompetition.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FactionCompetition toBeanIf()
/*      */     {
/*  934 */       return FactionCompetition.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getElo_rank()
/*      */     {
/*  941 */       FactionCompetition.this._xdb_verify_unsafe_();
/*  942 */       return FactionCompetition.this.elo_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPk_score()
/*      */     {
/*  949 */       FactionCompetition.this._xdb_verify_unsafe_();
/*  950 */       return FactionCompetition.this.pk_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPlayer_score()
/*      */     {
/*  957 */       FactionCompetition.this._xdb_verify_unsafe_();
/*  958 */       return FactionCompetition.this.player_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getParticipated()
/*      */     {
/*  965 */       FactionCompetition.this._xdb_verify_unsafe_();
/*  966 */       return FactionCompetition.this.participated;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpponent()
/*      */     {
/*  973 */       FactionCompetition.this._xdb_verify_unsafe_();
/*  974 */       return FactionCompetition.this.opponent;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/*  981 */       FactionCompetition.this._xdb_verify_unsafe_();
/*  982 */       return FactionCompetition.this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_times()
/*      */     {
/*  989 */       FactionCompetition.this._xdb_verify_unsafe_();
/*  990 */       return FactionCompetition.this.lose_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActive_number()
/*      */     {
/*  997 */       FactionCompetition.this._xdb_verify_unsafe_();
/*  998 */       return FactionCompetition.this.active_number;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLast_active_number()
/*      */     {
/* 1005 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1006 */       return FactionCompetition.this.last_active_number;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getActive_timestamp()
/*      */     {
/* 1013 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1014 */       return FactionCompetition.this.active_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMercenary_score()
/*      */     {
/* 1021 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1022 */       return FactionCompetition.this.mercenary_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPaticipate_count()
/*      */     {
/* 1029 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1030 */       return FactionCompetition.this.paticipate_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLast_partcipate_count()
/*      */     {
/* 1037 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1038 */       return FactionCompetition.this.last_partcipate_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getParticipate_roles()
/*      */     {
/* 1045 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1046 */       return Consts.constList(FactionCompetition.this.participate_roles);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getParticipate_rolesAsData()
/*      */     {
/* 1052 */       FactionCompetition.this._xdb_verify_unsafe_();
/*      */       
/* 1054 */       FactionCompetition _o_ = FactionCompetition.this;
/* 1055 */       List<Long> participate_roles = new ArrayList();
/* 1056 */       participate_roles.addAll(_o_.participate_roles);
/* 1057 */       return participate_roles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setElo_rank(int _v_)
/*      */     {
/* 1064 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1065 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPk_score(int _v_)
/*      */     {
/* 1072 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1073 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_score(int _v_)
/*      */     {
/* 1080 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1081 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipated(boolean _v_)
/*      */     {
/* 1088 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1089 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpponent(long _v_)
/*      */     {
/* 1096 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1097 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/* 1104 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1105 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_times(int _v_)
/*      */     {
/* 1112 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1113 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_number(int _v_)
/*      */     {
/* 1120 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1121 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_active_number(int _v_)
/*      */     {
/* 1128 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1129 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_timestamp(long _v_)
/*      */     {
/* 1136 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1137 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMercenary_score(int _v_)
/*      */     {
/* 1144 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1145 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPaticipate_count(int _v_)
/*      */     {
/* 1152 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1153 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_partcipate_count(int _v_)
/*      */     {
/* 1160 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1161 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/* 1167 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1168 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/* 1174 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1175 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1181 */       return FactionCompetition.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1187 */       return FactionCompetition.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1193 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1194 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1200 */       return FactionCompetition.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1206 */       return FactionCompetition.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1212 */       FactionCompetition.this._xdb_verify_unsafe_();
/* 1213 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/* 1219 */       return FactionCompetition.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1225 */       return FactionCompetition.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1231 */       return FactionCompetition.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1237 */       return FactionCompetition.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1243 */       return FactionCompetition.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1249 */       return FactionCompetition.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1255 */       return FactionCompetition.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FactionCompetition
/*      */   {
/*      */     private int elo_rank;
/*      */     
/*      */     private int pk_score;
/*      */     
/*      */     private int player_score;
/*      */     
/*      */     private boolean participated;
/*      */     
/*      */     private long opponent;
/*      */     
/*      */     private int win_times;
/*      */     
/*      */     private int lose_times;
/*      */     
/*      */     private int active_number;
/*      */     
/*      */     private int last_active_number;
/*      */     
/*      */     private long active_timestamp;
/*      */     
/*      */     private int mercenary_score;
/*      */     
/*      */     private int paticipate_count;
/*      */     
/*      */     private int last_partcipate_count;
/*      */     
/*      */     private ArrayList<Long> participate_roles;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1293 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1298 */       this.elo_rank = 0;
/* 1299 */       this.pk_score = 0;
/* 1300 */       this.player_score = 0;
/* 1301 */       this.participated = false;
/* 1302 */       this.opponent = -1L;
/* 1303 */       this.win_times = 0;
/* 1304 */       this.lose_times = 0;
/* 1305 */       this.active_number = 0;
/* 1306 */       this.last_active_number = 0;
/* 1307 */       this.active_timestamp = 0L;
/* 1308 */       this.mercenary_score = 0;
/* 1309 */       this.paticipate_count = 0;
/* 1310 */       this.last_partcipate_count = 0;
/* 1311 */       this.participate_roles = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.FactionCompetition _o1_)
/*      */     {
/* 1316 */       if ((_o1_ instanceof FactionCompetition)) { assign((FactionCompetition)_o1_);
/* 1317 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1318 */       } else if ((_o1_ instanceof FactionCompetition.Const)) assign(((FactionCompetition.Const)_o1_).nThis()); else {
/* 1319 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FactionCompetition _o_) {
/* 1324 */       this.elo_rank = _o_.elo_rank;
/* 1325 */       this.pk_score = _o_.pk_score;
/* 1326 */       this.player_score = _o_.player_score;
/* 1327 */       this.participated = _o_.participated;
/* 1328 */       this.opponent = _o_.opponent;
/* 1329 */       this.win_times = _o_.win_times;
/* 1330 */       this.lose_times = _o_.lose_times;
/* 1331 */       this.active_number = _o_.active_number;
/* 1332 */       this.last_active_number = _o_.last_active_number;
/* 1333 */       this.active_timestamp = _o_.active_timestamp;
/* 1334 */       this.mercenary_score = _o_.mercenary_score;
/* 1335 */       this.paticipate_count = _o_.paticipate_count;
/* 1336 */       this.last_partcipate_count = _o_.last_partcipate_count;
/* 1337 */       this.participate_roles = new ArrayList();
/* 1338 */       this.participate_roles.addAll(_o_.participate_roles);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1343 */       this.elo_rank = _o_.elo_rank;
/* 1344 */       this.pk_score = _o_.pk_score;
/* 1345 */       this.player_score = _o_.player_score;
/* 1346 */       this.participated = _o_.participated;
/* 1347 */       this.opponent = _o_.opponent;
/* 1348 */       this.win_times = _o_.win_times;
/* 1349 */       this.lose_times = _o_.lose_times;
/* 1350 */       this.active_number = _o_.active_number;
/* 1351 */       this.last_active_number = _o_.last_active_number;
/* 1352 */       this.active_timestamp = _o_.active_timestamp;
/* 1353 */       this.mercenary_score = _o_.mercenary_score;
/* 1354 */       this.paticipate_count = _o_.paticipate_count;
/* 1355 */       this.last_partcipate_count = _o_.last_partcipate_count;
/* 1356 */       this.participate_roles = new ArrayList();
/* 1357 */       this.participate_roles.addAll(_o_.participate_roles);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1363 */       _os_.marshal(this.elo_rank);
/* 1364 */       _os_.marshal(this.pk_score);
/* 1365 */       _os_.marshal(this.player_score);
/* 1366 */       _os_.marshal(this.participated);
/* 1367 */       _os_.marshal(this.opponent);
/* 1368 */       _os_.marshal(this.win_times);
/* 1369 */       _os_.marshal(this.lose_times);
/* 1370 */       _os_.marshal(this.active_number);
/* 1371 */       _os_.marshal(this.last_active_number);
/* 1372 */       _os_.marshal(this.active_timestamp);
/* 1373 */       _os_.marshal(this.mercenary_score);
/* 1374 */       _os_.marshal(this.paticipate_count);
/* 1375 */       _os_.marshal(this.last_partcipate_count);
/* 1376 */       _os_.compact_uint32(this.participate_roles.size());
/* 1377 */       for (Long _v_ : this.participate_roles)
/*      */       {
/* 1379 */         _os_.marshal(_v_.longValue());
/*      */       }
/* 1381 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1387 */       this.elo_rank = _os_.unmarshal_int();
/* 1388 */       this.pk_score = _os_.unmarshal_int();
/* 1389 */       this.player_score = _os_.unmarshal_int();
/* 1390 */       this.participated = _os_.unmarshal_boolean();
/* 1391 */       this.opponent = _os_.unmarshal_long();
/* 1392 */       this.win_times = _os_.unmarshal_int();
/* 1393 */       this.lose_times = _os_.unmarshal_int();
/* 1394 */       this.active_number = _os_.unmarshal_int();
/* 1395 */       this.last_active_number = _os_.unmarshal_int();
/* 1396 */       this.active_timestamp = _os_.unmarshal_long();
/* 1397 */       this.mercenary_score = _os_.unmarshal_int();
/* 1398 */       this.paticipate_count = _os_.unmarshal_int();
/* 1399 */       this.last_partcipate_count = _os_.unmarshal_int();
/* 1400 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/* 1402 */         long _v_ = 0L;
/* 1403 */         _v_ = _os_.unmarshal_long();
/* 1404 */         this.participate_roles.add(Long.valueOf(_v_));
/*      */       }
/* 1406 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1412 */       int _size_ = 0;
/* 1413 */       _size_ += CodedOutputStream.computeInt32Size(1, this.elo_rank);
/* 1414 */       _size_ += CodedOutputStream.computeInt32Size(2, this.pk_score);
/* 1415 */       _size_ += CodedOutputStream.computeInt32Size(3, this.player_score);
/* 1416 */       _size_ += CodedOutputStream.computeBoolSize(4, this.participated);
/* 1417 */       _size_ += CodedOutputStream.computeInt64Size(5, this.opponent);
/* 1418 */       _size_ += CodedOutputStream.computeInt32Size(6, this.win_times);
/* 1419 */       _size_ += CodedOutputStream.computeInt32Size(7, this.lose_times);
/* 1420 */       _size_ += CodedOutputStream.computeInt32Size(8, this.active_number);
/* 1421 */       _size_ += CodedOutputStream.computeInt32Size(9, this.last_active_number);
/* 1422 */       _size_ += CodedOutputStream.computeInt64Size(10, this.active_timestamp);
/* 1423 */       _size_ += CodedOutputStream.computeInt32Size(11, this.mercenary_score);
/* 1424 */       _size_ += CodedOutputStream.computeInt32Size(12, this.paticipate_count);
/* 1425 */       _size_ += CodedOutputStream.computeInt32Size(13, this.last_partcipate_count);
/* 1426 */       for (Long _v_ : this.participate_roles)
/*      */       {
/* 1428 */         _size_ += CodedOutputStream.computeInt64Size(14, _v_.longValue());
/*      */       }
/* 1430 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1438 */         _output_.writeInt32(1, this.elo_rank);
/* 1439 */         _output_.writeInt32(2, this.pk_score);
/* 1440 */         _output_.writeInt32(3, this.player_score);
/* 1441 */         _output_.writeBool(4, this.participated);
/* 1442 */         _output_.writeInt64(5, this.opponent);
/* 1443 */         _output_.writeInt32(6, this.win_times);
/* 1444 */         _output_.writeInt32(7, this.lose_times);
/* 1445 */         _output_.writeInt32(8, this.active_number);
/* 1446 */         _output_.writeInt32(9, this.last_active_number);
/* 1447 */         _output_.writeInt64(10, this.active_timestamp);
/* 1448 */         _output_.writeInt32(11, this.mercenary_score);
/* 1449 */         _output_.writeInt32(12, this.paticipate_count);
/* 1450 */         _output_.writeInt32(13, this.last_partcipate_count);
/* 1451 */         for (Long _v_ : this.participate_roles)
/*      */         {
/* 1453 */           _output_.writeInt64(14, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1458 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1460 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1468 */         boolean done = false;
/* 1469 */         while (!done)
/*      */         {
/* 1471 */           int tag = _input_.readTag();
/* 1472 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1476 */             done = true;
/* 1477 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1481 */             this.elo_rank = _input_.readInt32();
/* 1482 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1486 */             this.pk_score = _input_.readInt32();
/* 1487 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1491 */             this.player_score = _input_.readInt32();
/* 1492 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1496 */             this.participated = _input_.readBool();
/* 1497 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1501 */             this.opponent = _input_.readInt64();
/* 1502 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1506 */             this.win_times = _input_.readInt32();
/* 1507 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1511 */             this.lose_times = _input_.readInt32();
/* 1512 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1516 */             this.active_number = _input_.readInt32();
/* 1517 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1521 */             this.last_active_number = _input_.readInt32();
/* 1522 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1526 */             this.active_timestamp = _input_.readInt64();
/* 1527 */             break;
/*      */           
/*      */ 
/*      */           case 88: 
/* 1531 */             this.mercenary_score = _input_.readInt32();
/* 1532 */             break;
/*      */           
/*      */ 
/*      */           case 96: 
/* 1536 */             this.paticipate_count = _input_.readInt32();
/* 1537 */             break;
/*      */           
/*      */ 
/*      */           case 104: 
/* 1541 */             this.last_partcipate_count = _input_.readInt32();
/* 1542 */             break;
/*      */           
/*      */ 
/*      */           case 112: 
/* 1546 */             long _v_ = 0L;
/* 1547 */             _v_ = _input_.readInt64();
/* 1548 */             this.participate_roles.add(Long.valueOf(_v_));
/* 1549 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1553 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1555 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1564 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1568 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1570 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCompetition copy()
/*      */     {
/* 1576 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCompetition toData()
/*      */     {
/* 1582 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FactionCompetition toBean()
/*      */     {
/* 1587 */       return new FactionCompetition(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FactionCompetition toDataIf()
/*      */     {
/* 1593 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FactionCompetition toBeanIf()
/*      */     {
/* 1598 */       return new FactionCompetition(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1604 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1608 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1612 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1616 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1620 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1624 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1628 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getElo_rank()
/*      */     {
/* 1635 */       return this.elo_rank;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPk_score()
/*      */     {
/* 1642 */       return this.pk_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPlayer_score()
/*      */     {
/* 1649 */       return this.player_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getParticipated()
/*      */     {
/* 1656 */       return this.participated;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getOpponent()
/*      */     {
/* 1663 */       return this.opponent;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getWin_times()
/*      */     {
/* 1670 */       return this.win_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLose_times()
/*      */     {
/* 1677 */       return this.lose_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getActive_number()
/*      */     {
/* 1684 */       return this.active_number;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLast_active_number()
/*      */     {
/* 1691 */       return this.last_active_number;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getActive_timestamp()
/*      */     {
/* 1698 */       return this.active_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getMercenary_score()
/*      */     {
/* 1705 */       return this.mercenary_score;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPaticipate_count()
/*      */     {
/* 1712 */       return this.paticipate_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getLast_partcipate_count()
/*      */     {
/* 1719 */       return this.last_partcipate_count;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getParticipate_roles()
/*      */     {
/* 1726 */       return this.participate_roles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getParticipate_rolesAsData()
/*      */     {
/* 1733 */       return this.participate_roles;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setElo_rank(int _v_)
/*      */     {
/* 1740 */       this.elo_rank = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPk_score(int _v_)
/*      */     {
/* 1747 */       this.pk_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPlayer_score(int _v_)
/*      */     {
/* 1754 */       this.player_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setParticipated(boolean _v_)
/*      */     {
/* 1761 */       this.participated = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setOpponent(long _v_)
/*      */     {
/* 1768 */       this.opponent = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWin_times(int _v_)
/*      */     {
/* 1775 */       this.win_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLose_times(int _v_)
/*      */     {
/* 1782 */       this.lose_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_number(int _v_)
/*      */     {
/* 1789 */       this.active_number = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_active_number(int _v_)
/*      */     {
/* 1796 */       this.last_active_number = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setActive_timestamp(long _v_)
/*      */     {
/* 1803 */       this.active_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMercenary_score(int _v_)
/*      */     {
/* 1810 */       this.mercenary_score = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPaticipate_count(int _v_)
/*      */     {
/* 1817 */       this.paticipate_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_partcipate_count(int _v_)
/*      */     {
/* 1824 */       this.last_partcipate_count = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1830 */       if (!(_o1_ instanceof Data)) return false;
/* 1831 */       Data _o_ = (Data)_o1_;
/* 1832 */       if (this.elo_rank != _o_.elo_rank) return false;
/* 1833 */       if (this.pk_score != _o_.pk_score) return false;
/* 1834 */       if (this.player_score != _o_.player_score) return false;
/* 1835 */       if (this.participated != _o_.participated) return false;
/* 1836 */       if (this.opponent != _o_.opponent) return false;
/* 1837 */       if (this.win_times != _o_.win_times) return false;
/* 1838 */       if (this.lose_times != _o_.lose_times) return false;
/* 1839 */       if (this.active_number != _o_.active_number) return false;
/* 1840 */       if (this.last_active_number != _o_.last_active_number) return false;
/* 1841 */       if (this.active_timestamp != _o_.active_timestamp) return false;
/* 1842 */       if (this.mercenary_score != _o_.mercenary_score) return false;
/* 1843 */       if (this.paticipate_count != _o_.paticipate_count) return false;
/* 1844 */       if (this.last_partcipate_count != _o_.last_partcipate_count) return false;
/* 1845 */       if (!this.participate_roles.equals(_o_.participate_roles)) return false;
/* 1846 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1852 */       int _h_ = 0;
/* 1853 */       _h_ += this.elo_rank;
/* 1854 */       _h_ += this.pk_score;
/* 1855 */       _h_ += this.player_score;
/* 1856 */       _h_ += (this.participated ? 1231 : 1237);
/* 1857 */       _h_ = (int)(_h_ + this.opponent);
/* 1858 */       _h_ += this.win_times;
/* 1859 */       _h_ += this.lose_times;
/* 1860 */       _h_ += this.active_number;
/* 1861 */       _h_ += this.last_active_number;
/* 1862 */       _h_ = (int)(_h_ + this.active_timestamp);
/* 1863 */       _h_ += this.mercenary_score;
/* 1864 */       _h_ += this.paticipate_count;
/* 1865 */       _h_ += this.last_partcipate_count;
/* 1866 */       _h_ += this.participate_roles.hashCode();
/* 1867 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1873 */       StringBuilder _sb_ = new StringBuilder();
/* 1874 */       _sb_.append("(");
/* 1875 */       _sb_.append(this.elo_rank);
/* 1876 */       _sb_.append(",");
/* 1877 */       _sb_.append(this.pk_score);
/* 1878 */       _sb_.append(",");
/* 1879 */       _sb_.append(this.player_score);
/* 1880 */       _sb_.append(",");
/* 1881 */       _sb_.append(this.participated);
/* 1882 */       _sb_.append(",");
/* 1883 */       _sb_.append(this.opponent);
/* 1884 */       _sb_.append(",");
/* 1885 */       _sb_.append(this.win_times);
/* 1886 */       _sb_.append(",");
/* 1887 */       _sb_.append(this.lose_times);
/* 1888 */       _sb_.append(",");
/* 1889 */       _sb_.append(this.active_number);
/* 1890 */       _sb_.append(",");
/* 1891 */       _sb_.append(this.last_active_number);
/* 1892 */       _sb_.append(",");
/* 1893 */       _sb_.append(this.active_timestamp);
/* 1894 */       _sb_.append(",");
/* 1895 */       _sb_.append(this.mercenary_score);
/* 1896 */       _sb_.append(",");
/* 1897 */       _sb_.append(this.paticipate_count);
/* 1898 */       _sb_.append(",");
/* 1899 */       _sb_.append(this.last_partcipate_count);
/* 1900 */       _sb_.append(",");
/* 1901 */       _sb_.append(this.participate_roles);
/* 1902 */       _sb_.append(")");
/* 1903 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FactionCompetition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */