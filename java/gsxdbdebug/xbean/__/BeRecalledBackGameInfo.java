/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import java.io.IOException;
/*      */ import java.util.HashSet;
/*      */ import java.util.Set;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.util.SetX;
/*      */ 
/*      */ public final class BeRecalledBackGameInfo extends XBean implements xbean.BeRecalledBackGameInfo
/*      */ {
/*      */   private long back_game_time;
/*      */   private int back_game_reason;
/*      */   private long period_begin_time;
/*      */   private int current_period_be_recalled_times;
/*      */   private SetX<String> recall_user_set;
/*      */   private SetX<Integer> sign_awarded_day_set;
/*      */   private boolean big_gift_awarded_state;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.back_game_time = 0L;
/*   31 */     this.back_game_reason = 0;
/*   32 */     this.period_begin_time = 0L;
/*   33 */     this.current_period_be_recalled_times = 0;
/*   34 */     this.recall_user_set.clear();
/*   35 */     this.sign_awarded_day_set.clear();
/*   36 */     this.big_gift_awarded_state = false;
/*      */   }
/*      */   
/*      */   BeRecalledBackGameInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.recall_user_set = new SetX();
/*   43 */     this.sign_awarded_day_set = new SetX();
/*   44 */     this.big_gift_awarded_state = false;
/*      */   }
/*      */   
/*      */   public BeRecalledBackGameInfo()
/*      */   {
/*   49 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public BeRecalledBackGameInfo(BeRecalledBackGameInfo _o_)
/*      */   {
/*   54 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   BeRecalledBackGameInfo(xbean.BeRecalledBackGameInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   59 */     super(_xp_, _vn_);
/*   60 */     if ((_o1_ instanceof BeRecalledBackGameInfo)) { assign((BeRecalledBackGameInfo)_o1_);
/*   61 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   62 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   63 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(BeRecalledBackGameInfo _o_) {
/*   68 */     _o_._xdb_verify_unsafe_();
/*   69 */     this.back_game_time = _o_.back_game_time;
/*   70 */     this.back_game_reason = _o_.back_game_reason;
/*   71 */     this.period_begin_time = _o_.period_begin_time;
/*   72 */     this.current_period_be_recalled_times = _o_.current_period_be_recalled_times;
/*   73 */     this.recall_user_set = new SetX();
/*   74 */     this.recall_user_set.addAll(_o_.recall_user_set);
/*   75 */     this.sign_awarded_day_set = new SetX();
/*   76 */     this.sign_awarded_day_set.addAll(_o_.sign_awarded_day_set);
/*   77 */     this.big_gift_awarded_state = _o_.big_gift_awarded_state;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   82 */     this.back_game_time = _o_.back_game_time;
/*   83 */     this.back_game_reason = _o_.back_game_reason;
/*   84 */     this.period_begin_time = _o_.period_begin_time;
/*   85 */     this.current_period_be_recalled_times = _o_.current_period_be_recalled_times;
/*   86 */     this.recall_user_set = new SetX();
/*   87 */     this.recall_user_set.addAll(_o_.recall_user_set);
/*   88 */     this.sign_awarded_day_set = new SetX();
/*   89 */     this.sign_awarded_day_set.addAll(_o_.sign_awarded_day_set);
/*   90 */     this.big_gift_awarded_state = _o_.big_gift_awarded_state;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   96 */     _xdb_verify_unsafe_();
/*   97 */     _os_.marshal(this.back_game_time);
/*   98 */     _os_.marshal(this.back_game_reason);
/*   99 */     _os_.marshal(this.period_begin_time);
/*  100 */     _os_.marshal(this.current_period_be_recalled_times);
/*  101 */     _os_.compact_uint32(this.recall_user_set.size());
/*  102 */     for (String _v_ : this.recall_user_set)
/*      */     {
/*  104 */       _os_.marshal(_v_, "UTF-16LE");
/*      */     }
/*  106 */     _os_.compact_uint32(this.sign_awarded_day_set.size());
/*  107 */     for (Integer _v_ : this.sign_awarded_day_set)
/*      */     {
/*  109 */       _os_.marshal(_v_.intValue());
/*      */     }
/*  111 */     _os_.marshal(this.big_gift_awarded_state);
/*  112 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  118 */     _xdb_verify_unsafe_();
/*  119 */     this.back_game_time = _os_.unmarshal_long();
/*  120 */     this.back_game_reason = _os_.unmarshal_int();
/*  121 */     this.period_begin_time = _os_.unmarshal_long();
/*  122 */     this.current_period_be_recalled_times = _os_.unmarshal_int();
/*  123 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  125 */       String _v_ = "";
/*  126 */       _v_ = _os_.unmarshal_String("UTF-16LE");
/*  127 */       this.recall_user_set.add(_v_);
/*      */     }
/*  129 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  131 */       int _v_ = 0;
/*  132 */       _v_ = _os_.unmarshal_int();
/*  133 */       this.sign_awarded_day_set.add(Integer.valueOf(_v_));
/*      */     }
/*  135 */     this.big_gift_awarded_state = _os_.unmarshal_boolean();
/*  136 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  142 */     _xdb_verify_unsafe_();
/*  143 */     int _size_ = 0;
/*  144 */     _size_ += CodedOutputStream.computeInt64Size(1, this.back_game_time);
/*  145 */     _size_ += CodedOutputStream.computeInt32Size(2, this.back_game_reason);
/*  146 */     _size_ += CodedOutputStream.computeInt64Size(3, this.period_begin_time);
/*  147 */     _size_ += CodedOutputStream.computeInt32Size(4, this.current_period_be_recalled_times);
/*  148 */     for (String _v_ : this.recall_user_set)
/*      */     {
/*      */       try
/*      */       {
/*  152 */         _size_ += CodedOutputStream.computeBytesSize(5, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  156 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */     }
/*  159 */     for (Integer _v_ : this.sign_awarded_day_set)
/*      */     {
/*  161 */       _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */     }
/*  163 */     _size_ += CodedOutputStream.computeBoolSize(7, this.big_gift_awarded_state);
/*  164 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  170 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  173 */       _output_.writeInt64(1, this.back_game_time);
/*  174 */       _output_.writeInt32(2, this.back_game_reason);
/*  175 */       _output_.writeInt64(3, this.period_begin_time);
/*  176 */       _output_.writeInt32(4, this.current_period_be_recalled_times);
/*  177 */       for (String _v_ : this.recall_user_set)
/*      */       {
/*  179 */         _output_.writeBytes(5, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */       }
/*  181 */       for (Integer _v_ : this.sign_awarded_day_set)
/*      */       {
/*  183 */         _output_.writeInt32(6, _v_.intValue());
/*      */       }
/*  185 */       _output_.writeBool(7, this.big_gift_awarded_state);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  189 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  191 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  197 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  200 */       boolean done = false;
/*  201 */       while (!done)
/*      */       {
/*  203 */         int tag = _input_.readTag();
/*  204 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  208 */           done = true;
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  213 */           this.back_game_time = _input_.readInt64();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  218 */           this.back_game_reason = _input_.readInt32();
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  223 */           this.period_begin_time = _input_.readInt64();
/*  224 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  228 */           this.current_period_be_recalled_times = _input_.readInt32();
/*  229 */           break;
/*      */         
/*      */ 
/*      */         case 42: 
/*  233 */           String _v_ = "";
/*  234 */           _v_ = _input_.readBytes().toString("UTF-16LE");
/*  235 */           this.recall_user_set.add(_v_);
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  240 */           int _v_ = 0;
/*  241 */           _v_ = _input_.readInt32();
/*  242 */           this.sign_awarded_day_set.add(Integer.valueOf(_v_));
/*  243 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  247 */           this.big_gift_awarded_state = _input_.readBool();
/*  248 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  252 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  254 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  263 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  267 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  269 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BeRecalledBackGameInfo copy()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return new BeRecalledBackGameInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BeRecalledBackGameInfo toData()
/*      */   {
/*  282 */     _xdb_verify_unsafe_();
/*  283 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BeRecalledBackGameInfo toBean()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return new BeRecalledBackGameInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.BeRecalledBackGameInfo toDataIf()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.BeRecalledBackGameInfo toBeanIf()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBack_game_time()
/*      */   {
/*  316 */     _xdb_verify_unsafe_();
/*  317 */     return this.back_game_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getBack_game_reason()
/*      */   {
/*  324 */     _xdb_verify_unsafe_();
/*  325 */     return this.back_game_reason;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getPeriod_begin_time()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return this.period_begin_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrent_period_be_recalled_times()
/*      */   {
/*  340 */     _xdb_verify_unsafe_();
/*  341 */     return this.current_period_be_recalled_times;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<String> getRecall_user_set()
/*      */   {
/*  348 */     _xdb_verify_unsafe_();
/*  349 */     return Logs.logSet(new LogKey(this, "recall_user_set"), this.recall_user_set);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<String> getRecall_user_setAsData()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*      */     
/*  357 */     BeRecalledBackGameInfo _o_ = this;
/*  358 */     Set<String> recall_user_set = new SetX();
/*  359 */     recall_user_set.addAll(_o_.recall_user_set);
/*  360 */     return recall_user_set;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Set<Integer> getSign_awarded_day_set()
/*      */   {
/*  367 */     _xdb_verify_unsafe_();
/*  368 */     return Logs.logSet(new LogKey(this, "sign_awarded_day_set"), this.sign_awarded_day_set);
/*      */   }
/*      */   
/*      */ 
/*      */   public Set<Integer> getSign_awarded_day_setAsData()
/*      */   {
/*  374 */     _xdb_verify_unsafe_();
/*      */     
/*  376 */     BeRecalledBackGameInfo _o_ = this;
/*  377 */     Set<Integer> sign_awarded_day_set = new SetX();
/*  378 */     sign_awarded_day_set.addAll(_o_.sign_awarded_day_set);
/*  379 */     return sign_awarded_day_set;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getBig_gift_awarded_state()
/*      */   {
/*  386 */     _xdb_verify_unsafe_();
/*  387 */     return this.big_gift_awarded_state;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBack_game_time(long _v_)
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     Logs.logIf(new LogKey(this, "back_game_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  399 */         new xdb.logs.LogLong(this, BeRecalledBackGameInfo.this.back_game_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  403 */             BeRecalledBackGameInfo.this.back_game_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  407 */     });
/*  408 */     this.back_game_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBack_game_reason(int _v_)
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     Logs.logIf(new LogKey(this, "back_game_reason")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  420 */         new xdb.logs.LogInt(this, BeRecalledBackGameInfo.this.back_game_reason)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  424 */             BeRecalledBackGameInfo.this.back_game_reason = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  428 */     });
/*  429 */     this.back_game_reason = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPeriod_begin_time(long _v_)
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     Logs.logIf(new LogKey(this, "period_begin_time")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  441 */         new xdb.logs.LogLong(this, BeRecalledBackGameInfo.this.period_begin_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  445 */             BeRecalledBackGameInfo.this.period_begin_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  449 */     });
/*  450 */     this.period_begin_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrent_period_be_recalled_times(int _v_)
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     Logs.logIf(new LogKey(this, "current_period_be_recalled_times")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  462 */         new xdb.logs.LogInt(this, BeRecalledBackGameInfo.this.current_period_be_recalled_times)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  466 */             BeRecalledBackGameInfo.this.current_period_be_recalled_times = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  470 */     });
/*  471 */     this.current_period_be_recalled_times = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBig_gift_awarded_state(boolean _v_)
/*      */   {
/*  478 */     _xdb_verify_unsafe_();
/*  479 */     Logs.logIf(new LogKey(this, "big_gift_awarded_state")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  483 */         new xdb.logs.LogObject(this, Boolean.valueOf(BeRecalledBackGameInfo.this.big_gift_awarded_state))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  487 */             BeRecalledBackGameInfo.this.big_gift_awarded_state = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  491 */     });
/*  492 */     this.big_gift_awarded_state = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  498 */     _xdb_verify_unsafe_();
/*  499 */     BeRecalledBackGameInfo _o_ = null;
/*  500 */     if ((_o1_ instanceof BeRecalledBackGameInfo)) { _o_ = (BeRecalledBackGameInfo)_o1_;
/*  501 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  502 */       return false;
/*  503 */     if (this.back_game_time != _o_.back_game_time) return false;
/*  504 */     if (this.back_game_reason != _o_.back_game_reason) return false;
/*  505 */     if (this.period_begin_time != _o_.period_begin_time) return false;
/*  506 */     if (this.current_period_be_recalled_times != _o_.current_period_be_recalled_times) return false;
/*  507 */     if (!this.recall_user_set.equals(_o_.recall_user_set)) return false;
/*  508 */     if (!this.sign_awarded_day_set.equals(_o_.sign_awarded_day_set)) return false;
/*  509 */     if (this.big_gift_awarded_state != _o_.big_gift_awarded_state) return false;
/*  510 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  516 */     _xdb_verify_unsafe_();
/*  517 */     int _h_ = 0;
/*  518 */     _h_ = (int)(_h_ + this.back_game_time);
/*  519 */     _h_ += this.back_game_reason;
/*  520 */     _h_ = (int)(_h_ + this.period_begin_time);
/*  521 */     _h_ += this.current_period_be_recalled_times;
/*  522 */     _h_ += this.recall_user_set.hashCode();
/*  523 */     _h_ += this.sign_awarded_day_set.hashCode();
/*  524 */     _h_ += (this.big_gift_awarded_state ? 1231 : 1237);
/*  525 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  531 */     _xdb_verify_unsafe_();
/*  532 */     StringBuilder _sb_ = new StringBuilder();
/*  533 */     _sb_.append("(");
/*  534 */     _sb_.append(this.back_game_time);
/*  535 */     _sb_.append(",");
/*  536 */     _sb_.append(this.back_game_reason);
/*  537 */     _sb_.append(",");
/*  538 */     _sb_.append(this.period_begin_time);
/*  539 */     _sb_.append(",");
/*  540 */     _sb_.append(this.current_period_be_recalled_times);
/*  541 */     _sb_.append(",");
/*  542 */     _sb_.append(this.recall_user_set);
/*  543 */     _sb_.append(",");
/*  544 */     _sb_.append(this.sign_awarded_day_set);
/*  545 */     _sb_.append(",");
/*  546 */     _sb_.append(this.big_gift_awarded_state);
/*  547 */     _sb_.append(")");
/*  548 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  554 */     ListenableBean lb = new ListenableBean();
/*  555 */     lb.add(new ListenableChanged().setVarName("back_game_time"));
/*  556 */     lb.add(new ListenableChanged().setVarName("back_game_reason"));
/*  557 */     lb.add(new ListenableChanged().setVarName("period_begin_time"));
/*  558 */     lb.add(new ListenableChanged().setVarName("current_period_be_recalled_times"));
/*  559 */     lb.add(new xdb.logs.ListenableSet().setVarName("recall_user_set"));
/*  560 */     lb.add(new xdb.logs.ListenableSet().setVarName("sign_awarded_day_set"));
/*  561 */     lb.add(new ListenableChanged().setVarName("big_gift_awarded_state"));
/*  562 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.BeRecalledBackGameInfo {
/*      */     private Const() {}
/*      */     
/*      */     BeRecalledBackGameInfo nThis() {
/*  569 */       return BeRecalledBackGameInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  575 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BeRecalledBackGameInfo copy()
/*      */     {
/*  581 */       return BeRecalledBackGameInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BeRecalledBackGameInfo toData()
/*      */     {
/*  587 */       return BeRecalledBackGameInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.BeRecalledBackGameInfo toBean()
/*      */     {
/*  592 */       return BeRecalledBackGameInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BeRecalledBackGameInfo toDataIf()
/*      */     {
/*  598 */       return BeRecalledBackGameInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.BeRecalledBackGameInfo toBeanIf()
/*      */     {
/*  603 */       return BeRecalledBackGameInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBack_game_time()
/*      */     {
/*  610 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  611 */       return BeRecalledBackGameInfo.this.back_game_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBack_game_reason()
/*      */     {
/*  618 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  619 */       return BeRecalledBackGameInfo.this.back_game_reason;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPeriod_begin_time()
/*      */     {
/*  626 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  627 */       return BeRecalledBackGameInfo.this.period_begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_period_be_recalled_times()
/*      */     {
/*  634 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  635 */       return BeRecalledBackGameInfo.this.current_period_be_recalled_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<String> getRecall_user_set()
/*      */     {
/*  642 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  643 */       return xdb.Consts.constSet(BeRecalledBackGameInfo.this.recall_user_set);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<String> getRecall_user_setAsData()
/*      */     {
/*  649 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*      */       
/*  651 */       BeRecalledBackGameInfo _o_ = BeRecalledBackGameInfo.this;
/*  652 */       Set<String> recall_user_set = new SetX();
/*  653 */       recall_user_set.addAll(_o_.recall_user_set);
/*  654 */       return recall_user_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSign_awarded_day_set()
/*      */     {
/*  661 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  662 */       return xdb.Consts.constSet(BeRecalledBackGameInfo.this.sign_awarded_day_set);
/*      */     }
/*      */     
/*      */ 
/*      */     public Set<Integer> getSign_awarded_day_setAsData()
/*      */     {
/*  668 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*      */       
/*  670 */       BeRecalledBackGameInfo _o_ = BeRecalledBackGameInfo.this;
/*  671 */       Set<Integer> sign_awarded_day_set = new SetX();
/*  672 */       sign_awarded_day_set.addAll(_o_.sign_awarded_day_set);
/*  673 */       return sign_awarded_day_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getBig_gift_awarded_state()
/*      */     {
/*  680 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  681 */       return BeRecalledBackGameInfo.this.big_gift_awarded_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBack_game_time(long _v_)
/*      */     {
/*  688 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  689 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBack_game_reason(int _v_)
/*      */     {
/*  696 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  697 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPeriod_begin_time(long _v_)
/*      */     {
/*  704 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  705 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_period_be_recalled_times(int _v_)
/*      */     {
/*  712 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  713 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBig_gift_awarded_state(boolean _v_)
/*      */     {
/*  720 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  721 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  727 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  728 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  734 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  735 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  741 */       return BeRecalledBackGameInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  747 */       return BeRecalledBackGameInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  753 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  754 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  760 */       return BeRecalledBackGameInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  766 */       return BeRecalledBackGameInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  772 */       BeRecalledBackGameInfo.this._xdb_verify_unsafe_();
/*  773 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  779 */       return BeRecalledBackGameInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  785 */       return BeRecalledBackGameInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  791 */       return BeRecalledBackGameInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  797 */       return BeRecalledBackGameInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  803 */       return BeRecalledBackGameInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  809 */       return BeRecalledBackGameInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  815 */       return BeRecalledBackGameInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.BeRecalledBackGameInfo
/*      */   {
/*      */     private long back_game_time;
/*      */     
/*      */     private int back_game_reason;
/*      */     
/*      */     private long period_begin_time;
/*      */     
/*      */     private int current_period_be_recalled_times;
/*      */     
/*      */     private HashSet<String> recall_user_set;
/*      */     
/*      */     private HashSet<Integer> sign_awarded_day_set;
/*      */     
/*      */     private boolean big_gift_awarded_state;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  839 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  844 */       this.recall_user_set = new HashSet();
/*  845 */       this.sign_awarded_day_set = new HashSet();
/*  846 */       this.big_gift_awarded_state = false;
/*      */     }
/*      */     
/*      */     Data(xbean.BeRecalledBackGameInfo _o1_)
/*      */     {
/*  851 */       if ((_o1_ instanceof BeRecalledBackGameInfo)) { assign((BeRecalledBackGameInfo)_o1_);
/*  852 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  853 */       } else if ((_o1_ instanceof BeRecalledBackGameInfo.Const)) assign(((BeRecalledBackGameInfo.Const)_o1_).nThis()); else {
/*  854 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(BeRecalledBackGameInfo _o_) {
/*  859 */       this.back_game_time = _o_.back_game_time;
/*  860 */       this.back_game_reason = _o_.back_game_reason;
/*  861 */       this.period_begin_time = _o_.period_begin_time;
/*  862 */       this.current_period_be_recalled_times = _o_.current_period_be_recalled_times;
/*  863 */       this.recall_user_set = new HashSet();
/*  864 */       this.recall_user_set.addAll(_o_.recall_user_set);
/*  865 */       this.sign_awarded_day_set = new HashSet();
/*  866 */       this.sign_awarded_day_set.addAll(_o_.sign_awarded_day_set);
/*  867 */       this.big_gift_awarded_state = _o_.big_gift_awarded_state;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  872 */       this.back_game_time = _o_.back_game_time;
/*  873 */       this.back_game_reason = _o_.back_game_reason;
/*  874 */       this.period_begin_time = _o_.period_begin_time;
/*  875 */       this.current_period_be_recalled_times = _o_.current_period_be_recalled_times;
/*  876 */       this.recall_user_set = new HashSet();
/*  877 */       this.recall_user_set.addAll(_o_.recall_user_set);
/*  878 */       this.sign_awarded_day_set = new HashSet();
/*  879 */       this.sign_awarded_day_set.addAll(_o_.sign_awarded_day_set);
/*  880 */       this.big_gift_awarded_state = _o_.big_gift_awarded_state;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  886 */       _os_.marshal(this.back_game_time);
/*  887 */       _os_.marshal(this.back_game_reason);
/*  888 */       _os_.marshal(this.period_begin_time);
/*  889 */       _os_.marshal(this.current_period_be_recalled_times);
/*  890 */       _os_.compact_uint32(this.recall_user_set.size());
/*  891 */       for (String _v_ : this.recall_user_set)
/*      */       {
/*  893 */         _os_.marshal(_v_, "UTF-16LE");
/*      */       }
/*  895 */       _os_.compact_uint32(this.sign_awarded_day_set.size());
/*  896 */       for (Integer _v_ : this.sign_awarded_day_set)
/*      */       {
/*  898 */         _os_.marshal(_v_.intValue());
/*      */       }
/*  900 */       _os_.marshal(this.big_gift_awarded_state);
/*  901 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  907 */       this.back_game_time = _os_.unmarshal_long();
/*  908 */       this.back_game_reason = _os_.unmarshal_int();
/*  909 */       this.period_begin_time = _os_.unmarshal_long();
/*  910 */       this.current_period_be_recalled_times = _os_.unmarshal_int();
/*  911 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  913 */         String _v_ = "";
/*  914 */         _v_ = _os_.unmarshal_String("UTF-16LE");
/*  915 */         this.recall_user_set.add(_v_);
/*      */       }
/*  917 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  919 */         int _v_ = 0;
/*  920 */         _v_ = _os_.unmarshal_int();
/*  921 */         this.sign_awarded_day_set.add(Integer.valueOf(_v_));
/*      */       }
/*  923 */       this.big_gift_awarded_state = _os_.unmarshal_boolean();
/*  924 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  930 */       int _size_ = 0;
/*  931 */       _size_ += CodedOutputStream.computeInt64Size(1, this.back_game_time);
/*  932 */       _size_ += CodedOutputStream.computeInt32Size(2, this.back_game_reason);
/*  933 */       _size_ += CodedOutputStream.computeInt64Size(3, this.period_begin_time);
/*  934 */       _size_ += CodedOutputStream.computeInt32Size(4, this.current_period_be_recalled_times);
/*  935 */       for (String _v_ : this.recall_user_set)
/*      */       {
/*      */         try
/*      */         {
/*  939 */           _size_ += CodedOutputStream.computeBytesSize(5, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */         }
/*      */         catch (java.io.UnsupportedEncodingException e)
/*      */         {
/*  943 */           throw new RuntimeException("UTF-16LE not supported?", e);
/*      */         }
/*      */       }
/*  946 */       for (Integer _v_ : this.sign_awarded_day_set)
/*      */       {
/*  948 */         _size_ += CodedOutputStream.computeInt32Size(6, _v_.intValue());
/*      */       }
/*  950 */       _size_ += CodedOutputStream.computeBoolSize(7, this.big_gift_awarded_state);
/*  951 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  959 */         _output_.writeInt64(1, this.back_game_time);
/*  960 */         _output_.writeInt32(2, this.back_game_reason);
/*  961 */         _output_.writeInt64(3, this.period_begin_time);
/*  962 */         _output_.writeInt32(4, this.current_period_be_recalled_times);
/*  963 */         for (String _v_ : this.recall_user_set)
/*      */         {
/*  965 */           _output_.writeBytes(5, ByteString.copyFrom(_v_, "UTF-16LE"));
/*      */         }
/*  967 */         for (Integer _v_ : this.sign_awarded_day_set)
/*      */         {
/*  969 */           _output_.writeInt32(6, _v_.intValue());
/*      */         }
/*  971 */         _output_.writeBool(7, this.big_gift_awarded_state);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  975 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  977 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  985 */         boolean done = false;
/*  986 */         while (!done)
/*      */         {
/*  988 */           int tag = _input_.readTag();
/*  989 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  993 */             done = true;
/*  994 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  998 */             this.back_game_time = _input_.readInt64();
/*  999 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1003 */             this.back_game_reason = _input_.readInt32();
/* 1004 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1008 */             this.period_begin_time = _input_.readInt64();
/* 1009 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1013 */             this.current_period_be_recalled_times = _input_.readInt32();
/* 1014 */             break;
/*      */           
/*      */ 
/*      */           case 42: 
/* 1018 */             String _v_ = "";
/* 1019 */             _v_ = _input_.readBytes().toString("UTF-16LE");
/* 1020 */             this.recall_user_set.add(_v_);
/* 1021 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1025 */             int _v_ = 0;
/* 1026 */             _v_ = _input_.readInt32();
/* 1027 */             this.sign_awarded_day_set.add(Integer.valueOf(_v_));
/* 1028 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1032 */             this.big_gift_awarded_state = _input_.readBool();
/* 1033 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1037 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1039 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1048 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1052 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1054 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BeRecalledBackGameInfo copy()
/*      */     {
/* 1060 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BeRecalledBackGameInfo toData()
/*      */     {
/* 1066 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.BeRecalledBackGameInfo toBean()
/*      */     {
/* 1071 */       return new BeRecalledBackGameInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.BeRecalledBackGameInfo toDataIf()
/*      */     {
/* 1077 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.BeRecalledBackGameInfo toBeanIf()
/*      */     {
/* 1082 */       return new BeRecalledBackGameInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1088 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1092 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1096 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1100 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1104 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1108 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1112 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBack_game_time()
/*      */     {
/* 1119 */       return this.back_game_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getBack_game_reason()
/*      */     {
/* 1126 */       return this.back_game_reason;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getPeriod_begin_time()
/*      */     {
/* 1133 */       return this.period_begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrent_period_be_recalled_times()
/*      */     {
/* 1140 */       return this.current_period_be_recalled_times;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<String> getRecall_user_set()
/*      */     {
/* 1147 */       return this.recall_user_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<String> getRecall_user_setAsData()
/*      */     {
/* 1154 */       return this.recall_user_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSign_awarded_day_set()
/*      */     {
/* 1161 */       return this.sign_awarded_day_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Set<Integer> getSign_awarded_day_setAsData()
/*      */     {
/* 1168 */       return this.sign_awarded_day_set;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getBig_gift_awarded_state()
/*      */     {
/* 1175 */       return this.big_gift_awarded_state;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBack_game_time(long _v_)
/*      */     {
/* 1182 */       this.back_game_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBack_game_reason(int _v_)
/*      */     {
/* 1189 */       this.back_game_reason = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPeriod_begin_time(long _v_)
/*      */     {
/* 1196 */       this.period_begin_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrent_period_be_recalled_times(int _v_)
/*      */     {
/* 1203 */       this.current_period_be_recalled_times = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBig_gift_awarded_state(boolean _v_)
/*      */     {
/* 1210 */       this.big_gift_awarded_state = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1216 */       if (!(_o1_ instanceof Data)) return false;
/* 1217 */       Data _o_ = (Data)_o1_;
/* 1218 */       if (this.back_game_time != _o_.back_game_time) return false;
/* 1219 */       if (this.back_game_reason != _o_.back_game_reason) return false;
/* 1220 */       if (this.period_begin_time != _o_.period_begin_time) return false;
/* 1221 */       if (this.current_period_be_recalled_times != _o_.current_period_be_recalled_times) return false;
/* 1222 */       if (!this.recall_user_set.equals(_o_.recall_user_set)) return false;
/* 1223 */       if (!this.sign_awarded_day_set.equals(_o_.sign_awarded_day_set)) return false;
/* 1224 */       if (this.big_gift_awarded_state != _o_.big_gift_awarded_state) return false;
/* 1225 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1231 */       int _h_ = 0;
/* 1232 */       _h_ = (int)(_h_ + this.back_game_time);
/* 1233 */       _h_ += this.back_game_reason;
/* 1234 */       _h_ = (int)(_h_ + this.period_begin_time);
/* 1235 */       _h_ += this.current_period_be_recalled_times;
/* 1236 */       _h_ += this.recall_user_set.hashCode();
/* 1237 */       _h_ += this.sign_awarded_day_set.hashCode();
/* 1238 */       _h_ += (this.big_gift_awarded_state ? 1231 : 1237);
/* 1239 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1245 */       StringBuilder _sb_ = new StringBuilder();
/* 1246 */       _sb_.append("(");
/* 1247 */       _sb_.append(this.back_game_time);
/* 1248 */       _sb_.append(",");
/* 1249 */       _sb_.append(this.back_game_reason);
/* 1250 */       _sb_.append(",");
/* 1251 */       _sb_.append(this.period_begin_time);
/* 1252 */       _sb_.append(",");
/* 1253 */       _sb_.append(this.current_period_be_recalled_times);
/* 1254 */       _sb_.append(",");
/* 1255 */       _sb_.append(this.recall_user_set);
/* 1256 */       _sb_.append(",");
/* 1257 */       _sb_.append(this.sign_awarded_day_set);
/* 1258 */       _sb_.append(",");
/* 1259 */       _sb_.append(this.big_gift_awarded_state);
/* 1260 */       _sb_.append(")");
/* 1261 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BeRecalledBackGameInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */