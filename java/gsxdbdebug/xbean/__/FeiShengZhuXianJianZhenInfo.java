/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.MarshalException;
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Bean;
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
/*      */ public final class FeiShengZhuXianJianZhenInfo extends XBean implements xbean.FeiShengZhuXianJianZhenInfo
/*      */ {
/*      */   private int stage;
/*      */   private long world_id;
/*      */   private int commit_item_num;
/*      */   private int kill_monster_num;
/*      */   private long session_id;
/*      */   private long stage_collect_item_start_timestamp;
/*      */   private long stage_kill_monster_start_timestamp;
/*      */   private boolean have_get_activity_award;
/*      */   private int daily_try_times;
/*      */   private long daily_try_times_timestamp;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   36 */     this.stage = 0;
/*   37 */     this.world_id = -1L;
/*   38 */     this.commit_item_num = 0;
/*   39 */     this.kill_monster_num = 0;
/*   40 */     this.session_id = -1L;
/*   41 */     this.stage_collect_item_start_timestamp = -1L;
/*   42 */     this.stage_kill_monster_start_timestamp = -1L;
/*   43 */     this.have_get_activity_award = false;
/*   44 */     this.daily_try_times = 0;
/*   45 */     this.daily_try_times_timestamp = -1L;
/*      */   }
/*      */   
/*      */   FeiShengZhuXianJianZhenInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   50 */     super(_xp_, _vn_);
/*   51 */     this.stage = 0;
/*   52 */     this.world_id = -1L;
/*   53 */     this.commit_item_num = 0;
/*   54 */     this.kill_monster_num = 0;
/*   55 */     this.session_id = -1L;
/*   56 */     this.stage_collect_item_start_timestamp = -1L;
/*   57 */     this.stage_kill_monster_start_timestamp = -1L;
/*   58 */     this.have_get_activity_award = false;
/*   59 */     this.daily_try_times = 0;
/*   60 */     this.daily_try_times_timestamp = -1L;
/*      */   }
/*      */   
/*      */   public FeiShengZhuXianJianZhenInfo()
/*      */   {
/*   65 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public FeiShengZhuXianJianZhenInfo(FeiShengZhuXianJianZhenInfo _o_)
/*      */   {
/*   70 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   FeiShengZhuXianJianZhenInfo(xbean.FeiShengZhuXianJianZhenInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   75 */     super(_xp_, _vn_);
/*   76 */     if ((_o1_ instanceof FeiShengZhuXianJianZhenInfo)) { assign((FeiShengZhuXianJianZhenInfo)_o1_);
/*   77 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   78 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   79 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(FeiShengZhuXianJianZhenInfo _o_) {
/*   84 */     _o_._xdb_verify_unsafe_();
/*   85 */     this.stage = _o_.stage;
/*   86 */     this.world_id = _o_.world_id;
/*   87 */     this.commit_item_num = _o_.commit_item_num;
/*   88 */     this.kill_monster_num = _o_.kill_monster_num;
/*   89 */     this.session_id = _o_.session_id;
/*   90 */     this.stage_collect_item_start_timestamp = _o_.stage_collect_item_start_timestamp;
/*   91 */     this.stage_kill_monster_start_timestamp = _o_.stage_kill_monster_start_timestamp;
/*   92 */     this.have_get_activity_award = _o_.have_get_activity_award;
/*   93 */     this.daily_try_times = _o_.daily_try_times;
/*   94 */     this.daily_try_times_timestamp = _o_.daily_try_times_timestamp;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   99 */     this.stage = _o_.stage;
/*  100 */     this.world_id = _o_.world_id;
/*  101 */     this.commit_item_num = _o_.commit_item_num;
/*  102 */     this.kill_monster_num = _o_.kill_monster_num;
/*  103 */     this.session_id = _o_.session_id;
/*  104 */     this.stage_collect_item_start_timestamp = _o_.stage_collect_item_start_timestamp;
/*  105 */     this.stage_kill_monster_start_timestamp = _o_.stage_kill_monster_start_timestamp;
/*  106 */     this.have_get_activity_award = _o_.have_get_activity_award;
/*  107 */     this.daily_try_times = _o_.daily_try_times;
/*  108 */     this.daily_try_times_timestamp = _o_.daily_try_times_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  114 */     _xdb_verify_unsafe_();
/*  115 */     _os_.marshal(this.stage);
/*  116 */     _os_.marshal(this.world_id);
/*  117 */     _os_.marshal(this.commit_item_num);
/*  118 */     _os_.marshal(this.kill_monster_num);
/*  119 */     _os_.marshal(this.session_id);
/*  120 */     _os_.marshal(this.stage_collect_item_start_timestamp);
/*  121 */     _os_.marshal(this.stage_kill_monster_start_timestamp);
/*  122 */     _os_.marshal(this.have_get_activity_award);
/*  123 */     _os_.marshal(this.daily_try_times);
/*  124 */     _os_.marshal(this.daily_try_times_timestamp);
/*  125 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws MarshalException
/*      */   {
/*  131 */     _xdb_verify_unsafe_();
/*  132 */     this.stage = _os_.unmarshal_int();
/*  133 */     this.world_id = _os_.unmarshal_long();
/*  134 */     this.commit_item_num = _os_.unmarshal_int();
/*  135 */     this.kill_monster_num = _os_.unmarshal_int();
/*  136 */     this.session_id = _os_.unmarshal_long();
/*  137 */     this.stage_collect_item_start_timestamp = _os_.unmarshal_long();
/*  138 */     this.stage_kill_monster_start_timestamp = _os_.unmarshal_long();
/*  139 */     this.have_get_activity_award = _os_.unmarshal_boolean();
/*  140 */     this.daily_try_times = _os_.unmarshal_int();
/*  141 */     this.daily_try_times_timestamp = _os_.unmarshal_long();
/*  142 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  148 */     _xdb_verify_unsafe_();
/*  149 */     int _size_ = 0;
/*  150 */     _size_ += CodedOutputStream.computeInt32Size(1, this.stage);
/*  151 */     _size_ += CodedOutputStream.computeInt64Size(2, this.world_id);
/*  152 */     _size_ += CodedOutputStream.computeInt32Size(3, this.commit_item_num);
/*  153 */     _size_ += CodedOutputStream.computeInt32Size(4, this.kill_monster_num);
/*  154 */     _size_ += CodedOutputStream.computeInt64Size(5, this.session_id);
/*  155 */     _size_ += CodedOutputStream.computeInt64Size(6, this.stage_collect_item_start_timestamp);
/*  156 */     _size_ += CodedOutputStream.computeInt64Size(7, this.stage_kill_monster_start_timestamp);
/*  157 */     _size_ += CodedOutputStream.computeBoolSize(8, this.have_get_activity_award);
/*  158 */     _size_ += CodedOutputStream.computeInt32Size(9, this.daily_try_times);
/*  159 */     _size_ += CodedOutputStream.computeInt64Size(10, this.daily_try_times_timestamp);
/*  160 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  166 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  169 */       _output_.writeInt32(1, this.stage);
/*  170 */       _output_.writeInt64(2, this.world_id);
/*  171 */       _output_.writeInt32(3, this.commit_item_num);
/*  172 */       _output_.writeInt32(4, this.kill_monster_num);
/*  173 */       _output_.writeInt64(5, this.session_id);
/*  174 */       _output_.writeInt64(6, this.stage_collect_item_start_timestamp);
/*  175 */       _output_.writeInt64(7, this.stage_kill_monster_start_timestamp);
/*  176 */       _output_.writeBool(8, this.have_get_activity_award);
/*  177 */       _output_.writeInt32(9, this.daily_try_times);
/*  178 */       _output_.writeInt64(10, this.daily_try_times_timestamp);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  182 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  184 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  190 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  193 */       boolean done = false;
/*  194 */       while (!done)
/*      */       {
/*  196 */         int tag = _input_.readTag();
/*  197 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  201 */           done = true;
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  206 */           this.stage = _input_.readInt32();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  211 */           this.world_id = _input_.readInt64();
/*  212 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  216 */           this.commit_item_num = _input_.readInt32();
/*  217 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  221 */           this.kill_monster_num = _input_.readInt32();
/*  222 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  226 */           this.session_id = _input_.readInt64();
/*  227 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  231 */           this.stage_collect_item_start_timestamp = _input_.readInt64();
/*  232 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  236 */           this.stage_kill_monster_start_timestamp = _input_.readInt64();
/*  237 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  241 */           this.have_get_activity_award = _input_.readBool();
/*  242 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  246 */           this.daily_try_times = _input_.readInt32();
/*  247 */           break;
/*      */         
/*      */ 
/*      */         case 80: 
/*  251 */           this.daily_try_times_timestamp = _input_.readInt64();
/*  252 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  256 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  258 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  267 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  271 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  273 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FeiShengZhuXianJianZhenInfo copy()
/*      */   {
/*  279 */     _xdb_verify_unsafe_();
/*  280 */     return new FeiShengZhuXianJianZhenInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FeiShengZhuXianJianZhenInfo toData()
/*      */   {
/*  286 */     _xdb_verify_unsafe_();
/*  287 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FeiShengZhuXianJianZhenInfo toBean()
/*      */   {
/*  292 */     _xdb_verify_unsafe_();
/*  293 */     return new FeiShengZhuXianJianZhenInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.FeiShengZhuXianJianZhenInfo toDataIf()
/*      */   {
/*  299 */     _xdb_verify_unsafe_();
/*  300 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.FeiShengZhuXianJianZhenInfo toBeanIf()
/*      */   {
/*  305 */     _xdb_verify_unsafe_();
/*  306 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  312 */     _xdb_verify_unsafe_();
/*  313 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getStage()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return this.stage;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getWorld_id()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return this.world_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCommit_item_num()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return this.commit_item_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getKill_monster_num()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return this.kill_monster_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getSession_id()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     return this.session_id;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStage_collect_item_start_timestamp()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     return this.stage_collect_item_start_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStage_kill_monster_start_timestamp()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     return this.stage_kill_monster_start_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getHave_get_activity_award()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     return this.have_get_activity_award;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getDaily_try_times()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     return this.daily_try_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getDaily_try_times_timestamp()
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*  393 */     return this.daily_try_times_timestamp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStage(int _v_)
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     Logs.logIf(new LogKey(this, "stage")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  405 */         new LogInt(this, FeiShengZhuXianJianZhenInfo.this.stage)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  409 */             FeiShengZhuXianJianZhenInfo.this.stage = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  413 */     });
/*  414 */     this.stage = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setWorld_id(long _v_)
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     Logs.logIf(new LogKey(this, "world_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  426 */         new LogLong(this, FeiShengZhuXianJianZhenInfo.this.world_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  430 */             FeiShengZhuXianJianZhenInfo.this.world_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  434 */     });
/*  435 */     this.world_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCommit_item_num(int _v_)
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     Logs.logIf(new LogKey(this, "commit_item_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  447 */         new LogInt(this, FeiShengZhuXianJianZhenInfo.this.commit_item_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  451 */             FeiShengZhuXianJianZhenInfo.this.commit_item_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  455 */     });
/*  456 */     this.commit_item_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setKill_monster_num(int _v_)
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*  464 */     Logs.logIf(new LogKey(this, "kill_monster_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  468 */         new LogInt(this, FeiShengZhuXianJianZhenInfo.this.kill_monster_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  472 */             FeiShengZhuXianJianZhenInfo.this.kill_monster_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  476 */     });
/*  477 */     this.kill_monster_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setSession_id(long _v_)
/*      */   {
/*  484 */     _xdb_verify_unsafe_();
/*  485 */     Logs.logIf(new LogKey(this, "session_id")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  489 */         new LogLong(this, FeiShengZhuXianJianZhenInfo.this.session_id)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  493 */             FeiShengZhuXianJianZhenInfo.this.session_id = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  497 */     });
/*  498 */     this.session_id = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStage_collect_item_start_timestamp(long _v_)
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     Logs.logIf(new LogKey(this, "stage_collect_item_start_timestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  510 */         new LogLong(this, FeiShengZhuXianJianZhenInfo.this.stage_collect_item_start_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  514 */             FeiShengZhuXianJianZhenInfo.this.stage_collect_item_start_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  518 */     });
/*  519 */     this.stage_collect_item_start_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStage_kill_monster_start_timestamp(long _v_)
/*      */   {
/*  526 */     _xdb_verify_unsafe_();
/*  527 */     Logs.logIf(new LogKey(this, "stage_kill_monster_start_timestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  531 */         new LogLong(this, FeiShengZhuXianJianZhenInfo.this.stage_kill_monster_start_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  535 */             FeiShengZhuXianJianZhenInfo.this.stage_kill_monster_start_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  539 */     });
/*  540 */     this.stage_kill_monster_start_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHave_get_activity_award(boolean _v_)
/*      */   {
/*  547 */     _xdb_verify_unsafe_();
/*  548 */     Logs.logIf(new LogKey(this, "have_get_activity_award")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  552 */         new LogObject(this, Boolean.valueOf(FeiShengZhuXianJianZhenInfo.this.have_get_activity_award))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  556 */             FeiShengZhuXianJianZhenInfo.this.have_get_activity_award = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  560 */     });
/*  561 */     this.have_get_activity_award = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDaily_try_times(int _v_)
/*      */   {
/*  568 */     _xdb_verify_unsafe_();
/*  569 */     Logs.logIf(new LogKey(this, "daily_try_times")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  573 */         new LogInt(this, FeiShengZhuXianJianZhenInfo.this.daily_try_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  577 */             FeiShengZhuXianJianZhenInfo.this.daily_try_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  581 */     });
/*  582 */     this.daily_try_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setDaily_try_times_timestamp(long _v_)
/*      */   {
/*  589 */     _xdb_verify_unsafe_();
/*  590 */     Logs.logIf(new LogKey(this, "daily_try_times_timestamp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  594 */         new LogLong(this, FeiShengZhuXianJianZhenInfo.this.daily_try_times_timestamp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  598 */             FeiShengZhuXianJianZhenInfo.this.daily_try_times_timestamp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  602 */     });
/*  603 */     this.daily_try_times_timestamp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  609 */     _xdb_verify_unsafe_();
/*  610 */     FeiShengZhuXianJianZhenInfo _o_ = null;
/*  611 */     if ((_o1_ instanceof FeiShengZhuXianJianZhenInfo)) { _o_ = (FeiShengZhuXianJianZhenInfo)_o1_;
/*  612 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  613 */       return false;
/*  614 */     if (this.stage != _o_.stage) return false;
/*  615 */     if (this.world_id != _o_.world_id) return false;
/*  616 */     if (this.commit_item_num != _o_.commit_item_num) return false;
/*  617 */     if (this.kill_monster_num != _o_.kill_monster_num) return false;
/*  618 */     if (this.session_id != _o_.session_id) return false;
/*  619 */     if (this.stage_collect_item_start_timestamp != _o_.stage_collect_item_start_timestamp) return false;
/*  620 */     if (this.stage_kill_monster_start_timestamp != _o_.stage_kill_monster_start_timestamp) return false;
/*  621 */     if (this.have_get_activity_award != _o_.have_get_activity_award) return false;
/*  622 */     if (this.daily_try_times != _o_.daily_try_times) return false;
/*  623 */     if (this.daily_try_times_timestamp != _o_.daily_try_times_timestamp) return false;
/*  624 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  630 */     _xdb_verify_unsafe_();
/*  631 */     int _h_ = 0;
/*  632 */     _h_ += this.stage;
/*  633 */     _h_ = (int)(_h_ + this.world_id);
/*  634 */     _h_ += this.commit_item_num;
/*  635 */     _h_ += this.kill_monster_num;
/*  636 */     _h_ = (int)(_h_ + this.session_id);
/*  637 */     _h_ = (int)(_h_ + this.stage_collect_item_start_timestamp);
/*  638 */     _h_ = (int)(_h_ + this.stage_kill_monster_start_timestamp);
/*  639 */     _h_ += (this.have_get_activity_award ? 1231 : 1237);
/*  640 */     _h_ += this.daily_try_times;
/*  641 */     _h_ = (int)(_h_ + this.daily_try_times_timestamp);
/*  642 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  648 */     _xdb_verify_unsafe_();
/*  649 */     StringBuilder _sb_ = new StringBuilder();
/*  650 */     _sb_.append("(");
/*  651 */     _sb_.append(this.stage);
/*  652 */     _sb_.append(",");
/*  653 */     _sb_.append(this.world_id);
/*  654 */     _sb_.append(",");
/*  655 */     _sb_.append(this.commit_item_num);
/*  656 */     _sb_.append(",");
/*  657 */     _sb_.append(this.kill_monster_num);
/*  658 */     _sb_.append(",");
/*  659 */     _sb_.append(this.session_id);
/*  660 */     _sb_.append(",");
/*  661 */     _sb_.append(this.stage_collect_item_start_timestamp);
/*  662 */     _sb_.append(",");
/*  663 */     _sb_.append(this.stage_kill_monster_start_timestamp);
/*  664 */     _sb_.append(",");
/*  665 */     _sb_.append(this.have_get_activity_award);
/*  666 */     _sb_.append(",");
/*  667 */     _sb_.append(this.daily_try_times);
/*  668 */     _sb_.append(",");
/*  669 */     _sb_.append(this.daily_try_times_timestamp);
/*  670 */     _sb_.append(")");
/*  671 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public Listenable newListenable()
/*      */   {
/*  677 */     ListenableBean lb = new ListenableBean();
/*  678 */     lb.add(new ListenableChanged().setVarName("stage"));
/*  679 */     lb.add(new ListenableChanged().setVarName("world_id"));
/*  680 */     lb.add(new ListenableChanged().setVarName("commit_item_num"));
/*  681 */     lb.add(new ListenableChanged().setVarName("kill_monster_num"));
/*  682 */     lb.add(new ListenableChanged().setVarName("session_id"));
/*  683 */     lb.add(new ListenableChanged().setVarName("stage_collect_item_start_timestamp"));
/*  684 */     lb.add(new ListenableChanged().setVarName("stage_kill_monster_start_timestamp"));
/*  685 */     lb.add(new ListenableChanged().setVarName("have_get_activity_award"));
/*  686 */     lb.add(new ListenableChanged().setVarName("daily_try_times"));
/*  687 */     lb.add(new ListenableChanged().setVarName("daily_try_times_timestamp"));
/*  688 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.FeiShengZhuXianJianZhenInfo {
/*      */     private Const() {}
/*      */     
/*      */     FeiShengZhuXianJianZhenInfo nThis() {
/*  695 */       return FeiShengZhuXianJianZhenInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  701 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FeiShengZhuXianJianZhenInfo copy()
/*      */     {
/*  707 */       return FeiShengZhuXianJianZhenInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FeiShengZhuXianJianZhenInfo toData()
/*      */     {
/*  713 */       return FeiShengZhuXianJianZhenInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.FeiShengZhuXianJianZhenInfo toBean()
/*      */     {
/*  718 */       return FeiShengZhuXianJianZhenInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FeiShengZhuXianJianZhenInfo toDataIf()
/*      */     {
/*  724 */       return FeiShengZhuXianJianZhenInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.FeiShengZhuXianJianZhenInfo toBeanIf()
/*      */     {
/*  729 */       return FeiShengZhuXianJianZhenInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/*  736 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  737 */       return FeiShengZhuXianJianZhenInfo.this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorld_id()
/*      */     {
/*  744 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  745 */       return FeiShengZhuXianJianZhenInfo.this.world_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCommit_item_num()
/*      */     {
/*  752 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  753 */       return FeiShengZhuXianJianZhenInfo.this.commit_item_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getKill_monster_num()
/*      */     {
/*  760 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  761 */       return FeiShengZhuXianJianZhenInfo.this.kill_monster_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSession_id()
/*      */     {
/*  768 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  769 */       return FeiShengZhuXianJianZhenInfo.this.session_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStage_collect_item_start_timestamp()
/*      */     {
/*  776 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  777 */       return FeiShengZhuXianJianZhenInfo.this.stage_collect_item_start_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStage_kill_monster_start_timestamp()
/*      */     {
/*  784 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  785 */       return FeiShengZhuXianJianZhenInfo.this.stage_kill_monster_start_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHave_get_activity_award()
/*      */     {
/*  792 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  793 */       return FeiShengZhuXianJianZhenInfo.this.have_get_activity_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDaily_try_times()
/*      */     {
/*  800 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  801 */       return FeiShengZhuXianJianZhenInfo.this.daily_try_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDaily_try_times_timestamp()
/*      */     {
/*  808 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  809 */       return FeiShengZhuXianJianZhenInfo.this.daily_try_times_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/*  816 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  817 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorld_id(long _v_)
/*      */     {
/*  824 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  825 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCommit_item_num(int _v_)
/*      */     {
/*  832 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  833 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKill_monster_num(int _v_)
/*      */     {
/*  840 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  841 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSession_id(long _v_)
/*      */     {
/*  848 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  849 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage_collect_item_start_timestamp(long _v_)
/*      */     {
/*  856 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  857 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage_kill_monster_start_timestamp(long _v_)
/*      */     {
/*  864 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  865 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHave_get_activity_award(boolean _v_)
/*      */     {
/*  872 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  873 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDaily_try_times(int _v_)
/*      */     {
/*  880 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  881 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDaily_try_times_timestamp(long _v_)
/*      */     {
/*  888 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  889 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  895 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  896 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  902 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  903 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  909 */       return FeiShengZhuXianJianZhenInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  915 */       return FeiShengZhuXianJianZhenInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/*  921 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  922 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  928 */       return FeiShengZhuXianJianZhenInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  934 */       return FeiShengZhuXianJianZhenInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  940 */       FeiShengZhuXianJianZhenInfo.this._xdb_verify_unsafe_();
/*  941 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  947 */       return FeiShengZhuXianJianZhenInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  953 */       return FeiShengZhuXianJianZhenInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  959 */       return FeiShengZhuXianJianZhenInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  965 */       return FeiShengZhuXianJianZhenInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  971 */       return FeiShengZhuXianJianZhenInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  977 */       return FeiShengZhuXianJianZhenInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  983 */       return FeiShengZhuXianJianZhenInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.FeiShengZhuXianJianZhenInfo
/*      */   {
/*      */     private int stage;
/*      */     
/*      */     private long world_id;
/*      */     
/*      */     private int commit_item_num;
/*      */     
/*      */     private int kill_monster_num;
/*      */     
/*      */     private long session_id;
/*      */     
/*      */     private long stage_collect_item_start_timestamp;
/*      */     
/*      */     private long stage_kill_monster_start_timestamp;
/*      */     
/*      */     private boolean have_get_activity_award;
/*      */     
/*      */     private int daily_try_times;
/*      */     
/*      */     private long daily_try_times_timestamp;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1013 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1018 */       this.stage = 0;
/* 1019 */       this.world_id = -1L;
/* 1020 */       this.commit_item_num = 0;
/* 1021 */       this.kill_monster_num = 0;
/* 1022 */       this.session_id = -1L;
/* 1023 */       this.stage_collect_item_start_timestamp = -1L;
/* 1024 */       this.stage_kill_monster_start_timestamp = -1L;
/* 1025 */       this.have_get_activity_award = false;
/* 1026 */       this.daily_try_times = 0;
/* 1027 */       this.daily_try_times_timestamp = -1L;
/*      */     }
/*      */     
/*      */     Data(xbean.FeiShengZhuXianJianZhenInfo _o1_)
/*      */     {
/* 1032 */       if ((_o1_ instanceof FeiShengZhuXianJianZhenInfo)) { assign((FeiShengZhuXianJianZhenInfo)_o1_);
/* 1033 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1034 */       } else if ((_o1_ instanceof FeiShengZhuXianJianZhenInfo.Const)) assign(((FeiShengZhuXianJianZhenInfo.Const)_o1_).nThis()); else {
/* 1035 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(FeiShengZhuXianJianZhenInfo _o_) {
/* 1040 */       this.stage = _o_.stage;
/* 1041 */       this.world_id = _o_.world_id;
/* 1042 */       this.commit_item_num = _o_.commit_item_num;
/* 1043 */       this.kill_monster_num = _o_.kill_monster_num;
/* 1044 */       this.session_id = _o_.session_id;
/* 1045 */       this.stage_collect_item_start_timestamp = _o_.stage_collect_item_start_timestamp;
/* 1046 */       this.stage_kill_monster_start_timestamp = _o_.stage_kill_monster_start_timestamp;
/* 1047 */       this.have_get_activity_award = _o_.have_get_activity_award;
/* 1048 */       this.daily_try_times = _o_.daily_try_times;
/* 1049 */       this.daily_try_times_timestamp = _o_.daily_try_times_timestamp;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1054 */       this.stage = _o_.stage;
/* 1055 */       this.world_id = _o_.world_id;
/* 1056 */       this.commit_item_num = _o_.commit_item_num;
/* 1057 */       this.kill_monster_num = _o_.kill_monster_num;
/* 1058 */       this.session_id = _o_.session_id;
/* 1059 */       this.stage_collect_item_start_timestamp = _o_.stage_collect_item_start_timestamp;
/* 1060 */       this.stage_kill_monster_start_timestamp = _o_.stage_kill_monster_start_timestamp;
/* 1061 */       this.have_get_activity_award = _o_.have_get_activity_award;
/* 1062 */       this.daily_try_times = _o_.daily_try_times;
/* 1063 */       this.daily_try_times_timestamp = _o_.daily_try_times_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1069 */       _os_.marshal(this.stage);
/* 1070 */       _os_.marshal(this.world_id);
/* 1071 */       _os_.marshal(this.commit_item_num);
/* 1072 */       _os_.marshal(this.kill_monster_num);
/* 1073 */       _os_.marshal(this.session_id);
/* 1074 */       _os_.marshal(this.stage_collect_item_start_timestamp);
/* 1075 */       _os_.marshal(this.stage_kill_monster_start_timestamp);
/* 1076 */       _os_.marshal(this.have_get_activity_award);
/* 1077 */       _os_.marshal(this.daily_try_times);
/* 1078 */       _os_.marshal(this.daily_try_times_timestamp);
/* 1079 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws MarshalException
/*      */     {
/* 1085 */       this.stage = _os_.unmarshal_int();
/* 1086 */       this.world_id = _os_.unmarshal_long();
/* 1087 */       this.commit_item_num = _os_.unmarshal_int();
/* 1088 */       this.kill_monster_num = _os_.unmarshal_int();
/* 1089 */       this.session_id = _os_.unmarshal_long();
/* 1090 */       this.stage_collect_item_start_timestamp = _os_.unmarshal_long();
/* 1091 */       this.stage_kill_monster_start_timestamp = _os_.unmarshal_long();
/* 1092 */       this.have_get_activity_award = _os_.unmarshal_boolean();
/* 1093 */       this.daily_try_times = _os_.unmarshal_int();
/* 1094 */       this.daily_try_times_timestamp = _os_.unmarshal_long();
/* 1095 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1101 */       int _size_ = 0;
/* 1102 */       _size_ += CodedOutputStream.computeInt32Size(1, this.stage);
/* 1103 */       _size_ += CodedOutputStream.computeInt64Size(2, this.world_id);
/* 1104 */       _size_ += CodedOutputStream.computeInt32Size(3, this.commit_item_num);
/* 1105 */       _size_ += CodedOutputStream.computeInt32Size(4, this.kill_monster_num);
/* 1106 */       _size_ += CodedOutputStream.computeInt64Size(5, this.session_id);
/* 1107 */       _size_ += CodedOutputStream.computeInt64Size(6, this.stage_collect_item_start_timestamp);
/* 1108 */       _size_ += CodedOutputStream.computeInt64Size(7, this.stage_kill_monster_start_timestamp);
/* 1109 */       _size_ += CodedOutputStream.computeBoolSize(8, this.have_get_activity_award);
/* 1110 */       _size_ += CodedOutputStream.computeInt32Size(9, this.daily_try_times);
/* 1111 */       _size_ += CodedOutputStream.computeInt64Size(10, this.daily_try_times_timestamp);
/* 1112 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1120 */         _output_.writeInt32(1, this.stage);
/* 1121 */         _output_.writeInt64(2, this.world_id);
/* 1122 */         _output_.writeInt32(3, this.commit_item_num);
/* 1123 */         _output_.writeInt32(4, this.kill_monster_num);
/* 1124 */         _output_.writeInt64(5, this.session_id);
/* 1125 */         _output_.writeInt64(6, this.stage_collect_item_start_timestamp);
/* 1126 */         _output_.writeInt64(7, this.stage_kill_monster_start_timestamp);
/* 1127 */         _output_.writeBool(8, this.have_get_activity_award);
/* 1128 */         _output_.writeInt32(9, this.daily_try_times);
/* 1129 */         _output_.writeInt64(10, this.daily_try_times_timestamp);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1133 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1135 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1143 */         boolean done = false;
/* 1144 */         while (!done)
/*      */         {
/* 1146 */           int tag = _input_.readTag();
/* 1147 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1151 */             done = true;
/* 1152 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1156 */             this.stage = _input_.readInt32();
/* 1157 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1161 */             this.world_id = _input_.readInt64();
/* 1162 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1166 */             this.commit_item_num = _input_.readInt32();
/* 1167 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1171 */             this.kill_monster_num = _input_.readInt32();
/* 1172 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1176 */             this.session_id = _input_.readInt64();
/* 1177 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1181 */             this.stage_collect_item_start_timestamp = _input_.readInt64();
/* 1182 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1186 */             this.stage_kill_monster_start_timestamp = _input_.readInt64();
/* 1187 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1191 */             this.have_get_activity_award = _input_.readBool();
/* 1192 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1196 */             this.daily_try_times = _input_.readInt32();
/* 1197 */             break;
/*      */           
/*      */ 
/*      */           case 80: 
/* 1201 */             this.daily_try_times_timestamp = _input_.readInt64();
/* 1202 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1206 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1208 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1217 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1221 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1223 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FeiShengZhuXianJianZhenInfo copy()
/*      */     {
/* 1229 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FeiShengZhuXianJianZhenInfo toData()
/*      */     {
/* 1235 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.FeiShengZhuXianJianZhenInfo toBean()
/*      */     {
/* 1240 */       return new FeiShengZhuXianJianZhenInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.FeiShengZhuXianJianZhenInfo toDataIf()
/*      */     {
/* 1246 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.FeiShengZhuXianJianZhenInfo toBeanIf()
/*      */     {
/* 1251 */       return new FeiShengZhuXianJianZhenInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1257 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1261 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1265 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1269 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1273 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1277 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1281 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getStage()
/*      */     {
/* 1288 */       return this.stage;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getWorld_id()
/*      */     {
/* 1295 */       return this.world_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCommit_item_num()
/*      */     {
/* 1302 */       return this.commit_item_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getKill_monster_num()
/*      */     {
/* 1309 */       return this.kill_monster_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getSession_id()
/*      */     {
/* 1316 */       return this.session_id;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStage_collect_item_start_timestamp()
/*      */     {
/* 1323 */       return this.stage_collect_item_start_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStage_kill_monster_start_timestamp()
/*      */     {
/* 1330 */       return this.stage_kill_monster_start_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHave_get_activity_award()
/*      */     {
/* 1337 */       return this.have_get_activity_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getDaily_try_times()
/*      */     {
/* 1344 */       return this.daily_try_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getDaily_try_times_timestamp()
/*      */     {
/* 1351 */       return this.daily_try_times_timestamp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage(int _v_)
/*      */     {
/* 1358 */       this.stage = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setWorld_id(long _v_)
/*      */     {
/* 1365 */       this.world_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCommit_item_num(int _v_)
/*      */     {
/* 1372 */       this.commit_item_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setKill_monster_num(int _v_)
/*      */     {
/* 1379 */       this.kill_monster_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setSession_id(long _v_)
/*      */     {
/* 1386 */       this.session_id = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage_collect_item_start_timestamp(long _v_)
/*      */     {
/* 1393 */       this.stage_collect_item_start_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStage_kill_monster_start_timestamp(long _v_)
/*      */     {
/* 1400 */       this.stage_kill_monster_start_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHave_get_activity_award(boolean _v_)
/*      */     {
/* 1407 */       this.have_get_activity_award = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDaily_try_times(int _v_)
/*      */     {
/* 1414 */       this.daily_try_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setDaily_try_times_timestamp(long _v_)
/*      */     {
/* 1421 */       this.daily_try_times_timestamp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1427 */       if (!(_o1_ instanceof Data)) return false;
/* 1428 */       Data _o_ = (Data)_o1_;
/* 1429 */       if (this.stage != _o_.stage) return false;
/* 1430 */       if (this.world_id != _o_.world_id) return false;
/* 1431 */       if (this.commit_item_num != _o_.commit_item_num) return false;
/* 1432 */       if (this.kill_monster_num != _o_.kill_monster_num) return false;
/* 1433 */       if (this.session_id != _o_.session_id) return false;
/* 1434 */       if (this.stage_collect_item_start_timestamp != _o_.stage_collect_item_start_timestamp) return false;
/* 1435 */       if (this.stage_kill_monster_start_timestamp != _o_.stage_kill_monster_start_timestamp) return false;
/* 1436 */       if (this.have_get_activity_award != _o_.have_get_activity_award) return false;
/* 1437 */       if (this.daily_try_times != _o_.daily_try_times) return false;
/* 1438 */       if (this.daily_try_times_timestamp != _o_.daily_try_times_timestamp) return false;
/* 1439 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1445 */       int _h_ = 0;
/* 1446 */       _h_ += this.stage;
/* 1447 */       _h_ = (int)(_h_ + this.world_id);
/* 1448 */       _h_ += this.commit_item_num;
/* 1449 */       _h_ += this.kill_monster_num;
/* 1450 */       _h_ = (int)(_h_ + this.session_id);
/* 1451 */       _h_ = (int)(_h_ + this.stage_collect_item_start_timestamp);
/* 1452 */       _h_ = (int)(_h_ + this.stage_kill_monster_start_timestamp);
/* 1453 */       _h_ += (this.have_get_activity_award ? 1231 : 1237);
/* 1454 */       _h_ += this.daily_try_times;
/* 1455 */       _h_ = (int)(_h_ + this.daily_try_times_timestamp);
/* 1456 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1462 */       StringBuilder _sb_ = new StringBuilder();
/* 1463 */       _sb_.append("(");
/* 1464 */       _sb_.append(this.stage);
/* 1465 */       _sb_.append(",");
/* 1466 */       _sb_.append(this.world_id);
/* 1467 */       _sb_.append(",");
/* 1468 */       _sb_.append(this.commit_item_num);
/* 1469 */       _sb_.append(",");
/* 1470 */       _sb_.append(this.kill_monster_num);
/* 1471 */       _sb_.append(",");
/* 1472 */       _sb_.append(this.session_id);
/* 1473 */       _sb_.append(",");
/* 1474 */       _sb_.append(this.stage_collect_item_start_timestamp);
/* 1475 */       _sb_.append(",");
/* 1476 */       _sb_.append(this.stage_kill_monster_start_timestamp);
/* 1477 */       _sb_.append(",");
/* 1478 */       _sb_.append(this.have_get_activity_award);
/* 1479 */       _sb_.append(",");
/* 1480 */       _sb_.append(this.daily_try_times);
/* 1481 */       _sb_.append(",");
/* 1482 */       _sb_.append(this.daily_try_times_timestamp);
/* 1483 */       _sb_.append(")");
/* 1484 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FeiShengZhuXianJianZhenInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */