/*      */ package xbean.__;
/*      */ 
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
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ public final class MonthCardActivityInfo extends XBean implements xbean.MonthCardActivityInfo
/*      */ {
/*      */   private long buy_time;
/*      */   private long start_time;
/*      */   private long last_award_time;
/*      */   private int phase;
/*      */   private boolean is_present_award;
/*      */   private boolean is_fix_same_serviceid_bug;
/*      */   private long tss_end_time;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.buy_time = 0L;
/*   31 */     this.start_time = 0L;
/*   32 */     this.last_award_time = 0L;
/*   33 */     this.phase = 1;
/*   34 */     this.is_present_award = false;
/*   35 */     this.is_fix_same_serviceid_bug = false;
/*   36 */     this.tss_end_time = 0L;
/*      */   }
/*      */   
/*      */   MonthCardActivityInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.buy_time = 0L;
/*   43 */     this.start_time = 0L;
/*   44 */     this.last_award_time = 0L;
/*   45 */     this.phase = 1;
/*   46 */     this.is_present_award = false;
/*   47 */     this.is_fix_same_serviceid_bug = false;
/*   48 */     this.tss_end_time = 0L;
/*      */   }
/*      */   
/*      */   public MonthCardActivityInfo()
/*      */   {
/*   53 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public MonthCardActivityInfo(MonthCardActivityInfo _o_)
/*      */   {
/*   58 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   MonthCardActivityInfo(xbean.MonthCardActivityInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   63 */     super(_xp_, _vn_);
/*   64 */     if ((_o1_ instanceof MonthCardActivityInfo)) { assign((MonthCardActivityInfo)_o1_);
/*   65 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   66 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   67 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(MonthCardActivityInfo _o_) {
/*   72 */     _o_._xdb_verify_unsafe_();
/*   73 */     this.buy_time = _o_.buy_time;
/*   74 */     this.start_time = _o_.start_time;
/*   75 */     this.last_award_time = _o_.last_award_time;
/*   76 */     this.phase = _o_.phase;
/*   77 */     this.is_present_award = _o_.is_present_award;
/*   78 */     this.is_fix_same_serviceid_bug = _o_.is_fix_same_serviceid_bug;
/*   79 */     this.tss_end_time = _o_.tss_end_time;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   84 */     this.buy_time = _o_.buy_time;
/*   85 */     this.start_time = _o_.start_time;
/*   86 */     this.last_award_time = _o_.last_award_time;
/*   87 */     this.phase = _o_.phase;
/*   88 */     this.is_present_award = _o_.is_present_award;
/*   89 */     this.is_fix_same_serviceid_bug = _o_.is_fix_same_serviceid_bug;
/*   90 */     this.tss_end_time = _o_.tss_end_time;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   96 */     _xdb_verify_unsafe_();
/*   97 */     _os_.marshal(this.buy_time);
/*   98 */     _os_.marshal(this.start_time);
/*   99 */     _os_.marshal(this.last_award_time);
/*  100 */     _os_.marshal(this.phase);
/*  101 */     _os_.marshal(this.is_present_award);
/*  102 */     _os_.marshal(this.is_fix_same_serviceid_bug);
/*  103 */     _os_.marshal(this.tss_end_time);
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     this.buy_time = _os_.unmarshal_long();
/*  112 */     this.start_time = _os_.unmarshal_long();
/*  113 */     this.last_award_time = _os_.unmarshal_long();
/*  114 */     this.phase = _os_.unmarshal_int();
/*  115 */     this.is_present_award = _os_.unmarshal_boolean();
/*  116 */     this.is_fix_same_serviceid_bug = _os_.unmarshal_boolean();
/*  117 */     this.tss_end_time = _os_.unmarshal_long();
/*  118 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     int _size_ = 0;
/*  126 */     _size_ += CodedOutputStream.computeInt64Size(1, this.buy_time);
/*  127 */     _size_ += CodedOutputStream.computeInt64Size(2, this.start_time);
/*  128 */     _size_ += CodedOutputStream.computeInt64Size(3, this.last_award_time);
/*  129 */     _size_ += CodedOutputStream.computeInt32Size(4, this.phase);
/*  130 */     _size_ += CodedOutputStream.computeBoolSize(5, this.is_present_award);
/*  131 */     _size_ += CodedOutputStream.computeBoolSize(6, this.is_fix_same_serviceid_bug);
/*  132 */     _size_ += CodedOutputStream.computeInt64Size(7, this.tss_end_time);
/*  133 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  139 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  142 */       _output_.writeInt64(1, this.buy_time);
/*  143 */       _output_.writeInt64(2, this.start_time);
/*  144 */       _output_.writeInt64(3, this.last_award_time);
/*  145 */       _output_.writeInt32(4, this.phase);
/*  146 */       _output_.writeBool(5, this.is_present_award);
/*  147 */       _output_.writeBool(6, this.is_fix_same_serviceid_bug);
/*  148 */       _output_.writeInt64(7, this.tss_end_time);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  152 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  154 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  160 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  163 */       boolean done = false;
/*  164 */       while (!done)
/*      */       {
/*  166 */         int tag = _input_.readTag();
/*  167 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  171 */           done = true;
/*  172 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  176 */           this.buy_time = _input_.readInt64();
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  181 */           this.start_time = _input_.readInt64();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  186 */           this.last_award_time = _input_.readInt64();
/*  187 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  191 */           this.phase = _input_.readInt32();
/*  192 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  196 */           this.is_present_award = _input_.readBool();
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  201 */           this.is_fix_same_serviceid_bug = _input_.readBool();
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  206 */           this.tss_end_time = _input_.readInt64();
/*  207 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  211 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  213 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  222 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  226 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  228 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MonthCardActivityInfo copy()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new MonthCardActivityInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MonthCardActivityInfo toData()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MonthCardActivityInfo toBean()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new MonthCardActivityInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.MonthCardActivityInfo toDataIf()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.MonthCardActivityInfo toBeanIf()
/*      */   {
/*  260 */     _xdb_verify_unsafe_();
/*  261 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBuy_time()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return this.buy_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getStart_time()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return this.start_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getLast_award_time()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return this.last_award_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getPhase()
/*      */   {
/*  299 */     _xdb_verify_unsafe_();
/*  300 */     return this.phase;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_present_award()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return this.is_present_award;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getIs_fix_same_serviceid_bug()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return this.is_fix_same_serviceid_bug;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getTss_end_time()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     return this.tss_end_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBuy_time(long _v_)
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     Logs.logIf(new LogKey(this, "buy_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  336 */         new LogLong(this, MonthCardActivityInfo.this.buy_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  340 */             MonthCardActivityInfo.this.buy_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  344 */     });
/*  345 */     this.buy_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setStart_time(long _v_)
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     Logs.logIf(new LogKey(this, "start_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  357 */         new LogLong(this, MonthCardActivityInfo.this.start_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  361 */             MonthCardActivityInfo.this.start_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  365 */     });
/*  366 */     this.start_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setLast_award_time(long _v_)
/*      */   {
/*  373 */     _xdb_verify_unsafe_();
/*  374 */     Logs.logIf(new LogKey(this, "last_award_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  378 */         new LogLong(this, MonthCardActivityInfo.this.last_award_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  382 */             MonthCardActivityInfo.this.last_award_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  386 */     });
/*  387 */     this.last_award_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPhase(int _v_)
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     Logs.logIf(new LogKey(this, "phase")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  399 */         new xdb.logs.LogInt(this, MonthCardActivityInfo.this.phase)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  403 */             MonthCardActivityInfo.this.phase = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  407 */     });
/*  408 */     this.phase = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_present_award(boolean _v_)
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     Logs.logIf(new LogKey(this, "is_present_award")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  420 */         new LogObject(this, Boolean.valueOf(MonthCardActivityInfo.this.is_present_award))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  424 */             MonthCardActivityInfo.this.is_present_award = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  428 */     });
/*  429 */     this.is_present_award = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIs_fix_same_serviceid_bug(boolean _v_)
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     Logs.logIf(new LogKey(this, "is_fix_same_serviceid_bug")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  441 */         new LogObject(this, Boolean.valueOf(MonthCardActivityInfo.this.is_fix_same_serviceid_bug))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  445 */             MonthCardActivityInfo.this.is_fix_same_serviceid_bug = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  449 */     });
/*  450 */     this.is_fix_same_serviceid_bug = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTss_end_time(long _v_)
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     Logs.logIf(new LogKey(this, "tss_end_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  462 */         new LogLong(this, MonthCardActivityInfo.this.tss_end_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  466 */             MonthCardActivityInfo.this.tss_end_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  470 */     });
/*  471 */     this.tss_end_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     MonthCardActivityInfo _o_ = null;
/*  479 */     if ((_o1_ instanceof MonthCardActivityInfo)) { _o_ = (MonthCardActivityInfo)_o1_;
/*  480 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  481 */       return false;
/*  482 */     if (this.buy_time != _o_.buy_time) return false;
/*  483 */     if (this.start_time != _o_.start_time) return false;
/*  484 */     if (this.last_award_time != _o_.last_award_time) return false;
/*  485 */     if (this.phase != _o_.phase) return false;
/*  486 */     if (this.is_present_award != _o_.is_present_award) return false;
/*  487 */     if (this.is_fix_same_serviceid_bug != _o_.is_fix_same_serviceid_bug) return false;
/*  488 */     if (this.tss_end_time != _o_.tss_end_time) return false;
/*  489 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  495 */     _xdb_verify_unsafe_();
/*  496 */     int _h_ = 0;
/*  497 */     _h_ = (int)(_h_ + this.buy_time);
/*  498 */     _h_ = (int)(_h_ + this.start_time);
/*  499 */     _h_ = (int)(_h_ + this.last_award_time);
/*  500 */     _h_ += this.phase;
/*  501 */     _h_ += (this.is_present_award ? 1231 : 1237);
/*  502 */     _h_ += (this.is_fix_same_serviceid_bug ? 1231 : 1237);
/*  503 */     _h_ = (int)(_h_ + this.tss_end_time);
/*  504 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*  511 */     StringBuilder _sb_ = new StringBuilder();
/*  512 */     _sb_.append("(");
/*  513 */     _sb_.append(this.buy_time);
/*  514 */     _sb_.append(",");
/*  515 */     _sb_.append(this.start_time);
/*  516 */     _sb_.append(",");
/*  517 */     _sb_.append(this.last_award_time);
/*  518 */     _sb_.append(",");
/*  519 */     _sb_.append(this.phase);
/*  520 */     _sb_.append(",");
/*  521 */     _sb_.append(this.is_present_award);
/*  522 */     _sb_.append(",");
/*  523 */     _sb_.append(this.is_fix_same_serviceid_bug);
/*  524 */     _sb_.append(",");
/*  525 */     _sb_.append(this.tss_end_time);
/*  526 */     _sb_.append(")");
/*  527 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  533 */     ListenableBean lb = new ListenableBean();
/*  534 */     lb.add(new ListenableChanged().setVarName("buy_time"));
/*  535 */     lb.add(new ListenableChanged().setVarName("start_time"));
/*  536 */     lb.add(new ListenableChanged().setVarName("last_award_time"));
/*  537 */     lb.add(new ListenableChanged().setVarName("phase"));
/*  538 */     lb.add(new ListenableChanged().setVarName("is_present_award"));
/*  539 */     lb.add(new ListenableChanged().setVarName("is_fix_same_serviceid_bug"));
/*  540 */     lb.add(new ListenableChanged().setVarName("tss_end_time"));
/*  541 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.MonthCardActivityInfo {
/*      */     private Const() {}
/*      */     
/*      */     MonthCardActivityInfo nThis() {
/*  548 */       return MonthCardActivityInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  554 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MonthCardActivityInfo copy()
/*      */     {
/*  560 */       return MonthCardActivityInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MonthCardActivityInfo toData()
/*      */     {
/*  566 */       return MonthCardActivityInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.MonthCardActivityInfo toBean()
/*      */     {
/*  571 */       return MonthCardActivityInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MonthCardActivityInfo toDataIf()
/*      */     {
/*  577 */       return MonthCardActivityInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.MonthCardActivityInfo toBeanIf()
/*      */     {
/*  582 */       return MonthCardActivityInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBuy_time()
/*      */     {
/*  589 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  590 */       return MonthCardActivityInfo.this.buy_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/*  597 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  598 */       return MonthCardActivityInfo.this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_award_time()
/*      */     {
/*  605 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  606 */       return MonthCardActivityInfo.this.last_award_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPhase()
/*      */     {
/*  613 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  614 */       return MonthCardActivityInfo.this.phase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_present_award()
/*      */     {
/*  621 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  622 */       return MonthCardActivityInfo.this.is_present_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_fix_same_serviceid_bug()
/*      */     {
/*  629 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  630 */       return MonthCardActivityInfo.this.is_fix_same_serviceid_bug;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTss_end_time()
/*      */     {
/*  637 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  638 */       return MonthCardActivityInfo.this.tss_end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuy_time(long _v_)
/*      */     {
/*  645 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  646 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/*  653 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  654 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_award_time(long _v_)
/*      */     {
/*  661 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  662 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPhase(int _v_)
/*      */     {
/*  669 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  670 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_present_award(boolean _v_)
/*      */     {
/*  677 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  678 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_fix_same_serviceid_bug(boolean _v_)
/*      */     {
/*  685 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  686 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTss_end_time(long _v_)
/*      */     {
/*  693 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  694 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  700 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  701 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  707 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  708 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  714 */       return MonthCardActivityInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  720 */       return MonthCardActivityInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  726 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  727 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  733 */       return MonthCardActivityInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  739 */       return MonthCardActivityInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  745 */       MonthCardActivityInfo.this._xdb_verify_unsafe_();
/*  746 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  752 */       return MonthCardActivityInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  758 */       return MonthCardActivityInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  764 */       return MonthCardActivityInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  770 */       return MonthCardActivityInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  776 */       return MonthCardActivityInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  782 */       return MonthCardActivityInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  788 */       return MonthCardActivityInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.MonthCardActivityInfo
/*      */   {
/*      */     private long buy_time;
/*      */     
/*      */     private long start_time;
/*      */     
/*      */     private long last_award_time;
/*      */     
/*      */     private int phase;
/*      */     
/*      */     private boolean is_present_award;
/*      */     
/*      */     private boolean is_fix_same_serviceid_bug;
/*      */     
/*      */     private long tss_end_time;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  812 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  817 */       this.buy_time = 0L;
/*  818 */       this.start_time = 0L;
/*  819 */       this.last_award_time = 0L;
/*  820 */       this.phase = 1;
/*  821 */       this.is_present_award = false;
/*  822 */       this.is_fix_same_serviceid_bug = false;
/*  823 */       this.tss_end_time = 0L;
/*      */     }
/*      */     
/*      */     Data(xbean.MonthCardActivityInfo _o1_)
/*      */     {
/*  828 */       if ((_o1_ instanceof MonthCardActivityInfo)) { assign((MonthCardActivityInfo)_o1_);
/*  829 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  830 */       } else if ((_o1_ instanceof MonthCardActivityInfo.Const)) assign(((MonthCardActivityInfo.Const)_o1_).nThis()); else {
/*  831 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(MonthCardActivityInfo _o_) {
/*  836 */       this.buy_time = _o_.buy_time;
/*  837 */       this.start_time = _o_.start_time;
/*  838 */       this.last_award_time = _o_.last_award_time;
/*  839 */       this.phase = _o_.phase;
/*  840 */       this.is_present_award = _o_.is_present_award;
/*  841 */       this.is_fix_same_serviceid_bug = _o_.is_fix_same_serviceid_bug;
/*  842 */       this.tss_end_time = _o_.tss_end_time;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  847 */       this.buy_time = _o_.buy_time;
/*  848 */       this.start_time = _o_.start_time;
/*  849 */       this.last_award_time = _o_.last_award_time;
/*  850 */       this.phase = _o_.phase;
/*  851 */       this.is_present_award = _o_.is_present_award;
/*  852 */       this.is_fix_same_serviceid_bug = _o_.is_fix_same_serviceid_bug;
/*  853 */       this.tss_end_time = _o_.tss_end_time;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  859 */       _os_.marshal(this.buy_time);
/*  860 */       _os_.marshal(this.start_time);
/*  861 */       _os_.marshal(this.last_award_time);
/*  862 */       _os_.marshal(this.phase);
/*  863 */       _os_.marshal(this.is_present_award);
/*  864 */       _os_.marshal(this.is_fix_same_serviceid_bug);
/*  865 */       _os_.marshal(this.tss_end_time);
/*  866 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  872 */       this.buy_time = _os_.unmarshal_long();
/*  873 */       this.start_time = _os_.unmarshal_long();
/*  874 */       this.last_award_time = _os_.unmarshal_long();
/*  875 */       this.phase = _os_.unmarshal_int();
/*  876 */       this.is_present_award = _os_.unmarshal_boolean();
/*  877 */       this.is_fix_same_serviceid_bug = _os_.unmarshal_boolean();
/*  878 */       this.tss_end_time = _os_.unmarshal_long();
/*  879 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  885 */       int _size_ = 0;
/*  886 */       _size_ += CodedOutputStream.computeInt64Size(1, this.buy_time);
/*  887 */       _size_ += CodedOutputStream.computeInt64Size(2, this.start_time);
/*  888 */       _size_ += CodedOutputStream.computeInt64Size(3, this.last_award_time);
/*  889 */       _size_ += CodedOutputStream.computeInt32Size(4, this.phase);
/*  890 */       _size_ += CodedOutputStream.computeBoolSize(5, this.is_present_award);
/*  891 */       _size_ += CodedOutputStream.computeBoolSize(6, this.is_fix_same_serviceid_bug);
/*  892 */       _size_ += CodedOutputStream.computeInt64Size(7, this.tss_end_time);
/*  893 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  901 */         _output_.writeInt64(1, this.buy_time);
/*  902 */         _output_.writeInt64(2, this.start_time);
/*  903 */         _output_.writeInt64(3, this.last_award_time);
/*  904 */         _output_.writeInt32(4, this.phase);
/*  905 */         _output_.writeBool(5, this.is_present_award);
/*  906 */         _output_.writeBool(6, this.is_fix_same_serviceid_bug);
/*  907 */         _output_.writeInt64(7, this.tss_end_time);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  911 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  913 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  921 */         boolean done = false;
/*  922 */         while (!done)
/*      */         {
/*  924 */           int tag = _input_.readTag();
/*  925 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  929 */             done = true;
/*  930 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  934 */             this.buy_time = _input_.readInt64();
/*  935 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  939 */             this.start_time = _input_.readInt64();
/*  940 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  944 */             this.last_award_time = _input_.readInt64();
/*  945 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  949 */             this.phase = _input_.readInt32();
/*  950 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  954 */             this.is_present_award = _input_.readBool();
/*  955 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  959 */             this.is_fix_same_serviceid_bug = _input_.readBool();
/*  960 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/*  964 */             this.tss_end_time = _input_.readInt64();
/*  965 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  969 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  971 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  980 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  984 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  986 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MonthCardActivityInfo copy()
/*      */     {
/*  992 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MonthCardActivityInfo toData()
/*      */     {
/*  998 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.MonthCardActivityInfo toBean()
/*      */     {
/* 1003 */       return new MonthCardActivityInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.MonthCardActivityInfo toDataIf()
/*      */     {
/* 1009 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.MonthCardActivityInfo toBeanIf()
/*      */     {
/* 1014 */       return new MonthCardActivityInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1020 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/* 1024 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1028 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1032 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/* 1036 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1040 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1044 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBuy_time()
/*      */     {
/* 1051 */       return this.buy_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getStart_time()
/*      */     {
/* 1058 */       return this.start_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getLast_award_time()
/*      */     {
/* 1065 */       return this.last_award_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getPhase()
/*      */     {
/* 1072 */       return this.phase;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_present_award()
/*      */     {
/* 1079 */       return this.is_present_award;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getIs_fix_same_serviceid_bug()
/*      */     {
/* 1086 */       return this.is_fix_same_serviceid_bug;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getTss_end_time()
/*      */     {
/* 1093 */       return this.tss_end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBuy_time(long _v_)
/*      */     {
/* 1100 */       this.buy_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setStart_time(long _v_)
/*      */     {
/* 1107 */       this.start_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setLast_award_time(long _v_)
/*      */     {
/* 1114 */       this.last_award_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPhase(int _v_)
/*      */     {
/* 1121 */       this.phase = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_present_award(boolean _v_)
/*      */     {
/* 1128 */       this.is_present_award = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIs_fix_same_serviceid_bug(boolean _v_)
/*      */     {
/* 1135 */       this.is_fix_same_serviceid_bug = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTss_end_time(long _v_)
/*      */     {
/* 1142 */       this.tss_end_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1148 */       if (!(_o1_ instanceof Data)) return false;
/* 1149 */       Data _o_ = (Data)_o1_;
/* 1150 */       if (this.buy_time != _o_.buy_time) return false;
/* 1151 */       if (this.start_time != _o_.start_time) return false;
/* 1152 */       if (this.last_award_time != _o_.last_award_time) return false;
/* 1153 */       if (this.phase != _o_.phase) return false;
/* 1154 */       if (this.is_present_award != _o_.is_present_award) return false;
/* 1155 */       if (this.is_fix_same_serviceid_bug != _o_.is_fix_same_serviceid_bug) return false;
/* 1156 */       if (this.tss_end_time != _o_.tss_end_time) return false;
/* 1157 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1163 */       int _h_ = 0;
/* 1164 */       _h_ = (int)(_h_ + this.buy_time);
/* 1165 */       _h_ = (int)(_h_ + this.start_time);
/* 1166 */       _h_ = (int)(_h_ + this.last_award_time);
/* 1167 */       _h_ += this.phase;
/* 1168 */       _h_ += (this.is_present_award ? 1231 : 1237);
/* 1169 */       _h_ += (this.is_fix_same_serviceid_bug ? 1231 : 1237);
/* 1170 */       _h_ = (int)(_h_ + this.tss_end_time);
/* 1171 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1177 */       StringBuilder _sb_ = new StringBuilder();
/* 1178 */       _sb_.append("(");
/* 1179 */       _sb_.append(this.buy_time);
/* 1180 */       _sb_.append(",");
/* 1181 */       _sb_.append(this.start_time);
/* 1182 */       _sb_.append(",");
/* 1183 */       _sb_.append(this.last_award_time);
/* 1184 */       _sb_.append(",");
/* 1185 */       _sb_.append(this.phase);
/* 1186 */       _sb_.append(",");
/* 1187 */       _sb_.append(this.is_present_award);
/* 1188 */       _sb_.append(",");
/* 1189 */       _sb_.append(this.is_fix_same_serviceid_bug);
/* 1190 */       _sb_.append(",");
/* 1191 */       _sb_.append(this.tss_end_time);
/* 1192 */       _sb_.append(")");
/* 1193 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MonthCardActivityInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */