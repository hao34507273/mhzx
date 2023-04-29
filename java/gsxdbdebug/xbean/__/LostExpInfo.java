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
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogObject;
/*      */ 
/*      */ public final class LostExpInfo extends XBean implements xbean.LostExpInfo
/*      */ {
/*      */   private int totalloststoragevalue;
/*      */   private int totalgainloststoragevalue;
/*      */   private int alreadygetstoragevalue;
/*      */   private boolean alreadygainlostexp;
/*      */   private boolean cangainlostexp;
/*      */   private int gaincollectexp;
/*      */   private long begintime;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.totalloststoragevalue = 0;
/*   31 */     this.totalgainloststoragevalue = 0;
/*   32 */     this.alreadygetstoragevalue = 0;
/*   33 */     this.alreadygainlostexp = false;
/*   34 */     this.cangainlostexp = false;
/*   35 */     this.gaincollectexp = 0;
/*   36 */     this.begintime = 0L;
/*      */   }
/*      */   
/*      */   LostExpInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.totalloststoragevalue = 0;
/*   43 */     this.totalgainloststoragevalue = 0;
/*   44 */     this.alreadygetstoragevalue = 0;
/*   45 */     this.alreadygainlostexp = false;
/*   46 */     this.cangainlostexp = false;
/*   47 */     this.gaincollectexp = 0;
/*   48 */     this.begintime = 0L;
/*      */   }
/*      */   
/*      */   public LostExpInfo()
/*      */   {
/*   53 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public LostExpInfo(LostExpInfo _o_)
/*      */   {
/*   58 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   LostExpInfo(xbean.LostExpInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   63 */     super(_xp_, _vn_);
/*   64 */     if ((_o1_ instanceof LostExpInfo)) { assign((LostExpInfo)_o1_);
/*   65 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   66 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   67 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(LostExpInfo _o_) {
/*   72 */     _o_._xdb_verify_unsafe_();
/*   73 */     this.totalloststoragevalue = _o_.totalloststoragevalue;
/*   74 */     this.totalgainloststoragevalue = _o_.totalgainloststoragevalue;
/*   75 */     this.alreadygetstoragevalue = _o_.alreadygetstoragevalue;
/*   76 */     this.alreadygainlostexp = _o_.alreadygainlostexp;
/*   77 */     this.cangainlostexp = _o_.cangainlostexp;
/*   78 */     this.gaincollectexp = _o_.gaincollectexp;
/*   79 */     this.begintime = _o_.begintime;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   84 */     this.totalloststoragevalue = _o_.totalloststoragevalue;
/*   85 */     this.totalgainloststoragevalue = _o_.totalgainloststoragevalue;
/*   86 */     this.alreadygetstoragevalue = _o_.alreadygetstoragevalue;
/*   87 */     this.alreadygainlostexp = _o_.alreadygainlostexp;
/*   88 */     this.cangainlostexp = _o_.cangainlostexp;
/*   89 */     this.gaincollectexp = _o_.gaincollectexp;
/*   90 */     this.begintime = _o_.begintime;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   96 */     _xdb_verify_unsafe_();
/*   97 */     _os_.marshal(this.totalloststoragevalue);
/*   98 */     _os_.marshal(this.totalgainloststoragevalue);
/*   99 */     _os_.marshal(this.alreadygetstoragevalue);
/*  100 */     _os_.marshal(this.alreadygainlostexp);
/*  101 */     _os_.marshal(this.cangainlostexp);
/*  102 */     _os_.marshal(this.gaincollectexp);
/*  103 */     _os_.marshal(this.begintime);
/*  104 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  110 */     _xdb_verify_unsafe_();
/*  111 */     this.totalloststoragevalue = _os_.unmarshal_int();
/*  112 */     this.totalgainloststoragevalue = _os_.unmarshal_int();
/*  113 */     this.alreadygetstoragevalue = _os_.unmarshal_int();
/*  114 */     this.alreadygainlostexp = _os_.unmarshal_boolean();
/*  115 */     this.cangainlostexp = _os_.unmarshal_boolean();
/*  116 */     this.gaincollectexp = _os_.unmarshal_int();
/*  117 */     this.begintime = _os_.unmarshal_long();
/*  118 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     int _size_ = 0;
/*  126 */     _size_ += CodedOutputStream.computeInt32Size(1, this.totalloststoragevalue);
/*  127 */     _size_ += CodedOutputStream.computeInt32Size(2, this.totalgainloststoragevalue);
/*  128 */     _size_ += CodedOutputStream.computeInt32Size(3, this.alreadygetstoragevalue);
/*  129 */     _size_ += CodedOutputStream.computeBoolSize(4, this.alreadygainlostexp);
/*  130 */     _size_ += CodedOutputStream.computeBoolSize(5, this.cangainlostexp);
/*  131 */     _size_ += CodedOutputStream.computeInt32Size(6, this.gaincollectexp);
/*  132 */     _size_ += CodedOutputStream.computeInt64Size(7, this.begintime);
/*  133 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  139 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  142 */       _output_.writeInt32(1, this.totalloststoragevalue);
/*  143 */       _output_.writeInt32(2, this.totalgainloststoragevalue);
/*  144 */       _output_.writeInt32(3, this.alreadygetstoragevalue);
/*  145 */       _output_.writeBool(4, this.alreadygainlostexp);
/*  146 */       _output_.writeBool(5, this.cangainlostexp);
/*  147 */       _output_.writeInt32(6, this.gaincollectexp);
/*  148 */       _output_.writeInt64(7, this.begintime);
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
/*  176 */           this.totalloststoragevalue = _input_.readInt32();
/*  177 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  181 */           this.totalgainloststoragevalue = _input_.readInt32();
/*  182 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  186 */           this.alreadygetstoragevalue = _input_.readInt32();
/*  187 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  191 */           this.alreadygainlostexp = _input_.readBool();
/*  192 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  196 */           this.cangainlostexp = _input_.readBool();
/*  197 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  201 */           this.gaincollectexp = _input_.readInt32();
/*  202 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  206 */           this.begintime = _input_.readInt64();
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
/*      */   public xbean.LostExpInfo copy()
/*      */   {
/*  234 */     _xdb_verify_unsafe_();
/*  235 */     return new LostExpInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.LostExpInfo toData()
/*      */   {
/*  241 */     _xdb_verify_unsafe_();
/*  242 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.LostExpInfo toBean()
/*      */   {
/*  247 */     _xdb_verify_unsafe_();
/*  248 */     return new LostExpInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.LostExpInfo toDataIf()
/*      */   {
/*  254 */     _xdb_verify_unsafe_();
/*  255 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.LostExpInfo toBeanIf()
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
/*      */   public int getTotalloststoragevalue()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return this.totalloststoragevalue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getTotalgainloststoragevalue()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return this.totalgainloststoragevalue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getAlreadygetstoragevalue()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return this.alreadygetstoragevalue;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getAlreadygainlostexp()
/*      */   {
/*  299 */     _xdb_verify_unsafe_();
/*  300 */     return this.alreadygainlostexp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getCangainlostexp()
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     return this.cangainlostexp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getGaincollectexp()
/*      */   {
/*  315 */     _xdb_verify_unsafe_();
/*  316 */     return this.gaincollectexp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBegintime()
/*      */   {
/*  323 */     _xdb_verify_unsafe_();
/*  324 */     return this.begintime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotalloststoragevalue(int _v_)
/*      */   {
/*  331 */     _xdb_verify_unsafe_();
/*  332 */     Logs.logIf(new LogKey(this, "totalloststoragevalue")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  336 */         new LogInt(this, LostExpInfo.this.totalloststoragevalue)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  340 */             LostExpInfo.this.totalloststoragevalue = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  344 */     });
/*  345 */     this.totalloststoragevalue = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setTotalgainloststoragevalue(int _v_)
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     Logs.logIf(new LogKey(this, "totalgainloststoragevalue")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  357 */         new LogInt(this, LostExpInfo.this.totalgainloststoragevalue)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  361 */             LostExpInfo.this.totalgainloststoragevalue = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  365 */     });
/*  366 */     this.totalgainloststoragevalue = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAlreadygetstoragevalue(int _v_)
/*      */   {
/*  373 */     _xdb_verify_unsafe_();
/*  374 */     Logs.logIf(new LogKey(this, "alreadygetstoragevalue")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  378 */         new LogInt(this, LostExpInfo.this.alreadygetstoragevalue)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  382 */             LostExpInfo.this.alreadygetstoragevalue = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  386 */     });
/*  387 */     this.alreadygetstoragevalue = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAlreadygainlostexp(boolean _v_)
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*  395 */     Logs.logIf(new LogKey(this, "alreadygainlostexp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  399 */         new LogObject(this, Boolean.valueOf(LostExpInfo.this.alreadygainlostexp))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  403 */             LostExpInfo.this.alreadygainlostexp = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  407 */     });
/*  408 */     this.alreadygainlostexp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCangainlostexp(boolean _v_)
/*      */   {
/*  415 */     _xdb_verify_unsafe_();
/*  416 */     Logs.logIf(new LogKey(this, "cangainlostexp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  420 */         new LogObject(this, Boolean.valueOf(LostExpInfo.this.cangainlostexp))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  424 */             LostExpInfo.this.cangainlostexp = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  428 */     });
/*  429 */     this.cangainlostexp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGaincollectexp(int _v_)
/*      */   {
/*  436 */     _xdb_verify_unsafe_();
/*  437 */     Logs.logIf(new LogKey(this, "gaincollectexp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  441 */         new LogInt(this, LostExpInfo.this.gaincollectexp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  445 */             LostExpInfo.this.gaincollectexp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  449 */     });
/*  450 */     this.gaincollectexp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBegintime(long _v_)
/*      */   {
/*  457 */     _xdb_verify_unsafe_();
/*  458 */     Logs.logIf(new LogKey(this, "begintime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  462 */         new xdb.logs.LogLong(this, LostExpInfo.this.begintime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  466 */             LostExpInfo.this.begintime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  470 */     });
/*  471 */     this.begintime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  477 */     _xdb_verify_unsafe_();
/*  478 */     LostExpInfo _o_ = null;
/*  479 */     if ((_o1_ instanceof LostExpInfo)) { _o_ = (LostExpInfo)_o1_;
/*  480 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  481 */       return false;
/*  482 */     if (this.totalloststoragevalue != _o_.totalloststoragevalue) return false;
/*  483 */     if (this.totalgainloststoragevalue != _o_.totalgainloststoragevalue) return false;
/*  484 */     if (this.alreadygetstoragevalue != _o_.alreadygetstoragevalue) return false;
/*  485 */     if (this.alreadygainlostexp != _o_.alreadygainlostexp) return false;
/*  486 */     if (this.cangainlostexp != _o_.cangainlostexp) return false;
/*  487 */     if (this.gaincollectexp != _o_.gaincollectexp) return false;
/*  488 */     if (this.begintime != _o_.begintime) return false;
/*  489 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  495 */     _xdb_verify_unsafe_();
/*  496 */     int _h_ = 0;
/*  497 */     _h_ += this.totalloststoragevalue;
/*  498 */     _h_ += this.totalgainloststoragevalue;
/*  499 */     _h_ += this.alreadygetstoragevalue;
/*  500 */     _h_ += (this.alreadygainlostexp ? 1231 : 1237);
/*  501 */     _h_ += (this.cangainlostexp ? 1231 : 1237);
/*  502 */     _h_ += this.gaincollectexp;
/*  503 */     _h_ = (int)(_h_ + this.begintime);
/*  504 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  510 */     _xdb_verify_unsafe_();
/*  511 */     StringBuilder _sb_ = new StringBuilder();
/*  512 */     _sb_.append("(");
/*  513 */     _sb_.append(this.totalloststoragevalue);
/*  514 */     _sb_.append(",");
/*  515 */     _sb_.append(this.totalgainloststoragevalue);
/*  516 */     _sb_.append(",");
/*  517 */     _sb_.append(this.alreadygetstoragevalue);
/*  518 */     _sb_.append(",");
/*  519 */     _sb_.append(this.alreadygainlostexp);
/*  520 */     _sb_.append(",");
/*  521 */     _sb_.append(this.cangainlostexp);
/*  522 */     _sb_.append(",");
/*  523 */     _sb_.append(this.gaincollectexp);
/*  524 */     _sb_.append(",");
/*  525 */     _sb_.append(this.begintime);
/*  526 */     _sb_.append(")");
/*  527 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  533 */     ListenableBean lb = new ListenableBean();
/*  534 */     lb.add(new ListenableChanged().setVarName("totalloststoragevalue"));
/*  535 */     lb.add(new ListenableChanged().setVarName("totalgainloststoragevalue"));
/*  536 */     lb.add(new ListenableChanged().setVarName("alreadygetstoragevalue"));
/*  537 */     lb.add(new ListenableChanged().setVarName("alreadygainlostexp"));
/*  538 */     lb.add(new ListenableChanged().setVarName("cangainlostexp"));
/*  539 */     lb.add(new ListenableChanged().setVarName("gaincollectexp"));
/*  540 */     lb.add(new ListenableChanged().setVarName("begintime"));
/*  541 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.LostExpInfo {
/*      */     private Const() {}
/*      */     
/*      */     LostExpInfo nThis() {
/*  548 */       return LostExpInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  554 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LostExpInfo copy()
/*      */     {
/*  560 */       return LostExpInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LostExpInfo toData()
/*      */     {
/*  566 */       return LostExpInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.LostExpInfo toBean()
/*      */     {
/*  571 */       return LostExpInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LostExpInfo toDataIf()
/*      */     {
/*  577 */       return LostExpInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.LostExpInfo toBeanIf()
/*      */     {
/*  582 */       return LostExpInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotalloststoragevalue()
/*      */     {
/*  589 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  590 */       return LostExpInfo.this.totalloststoragevalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotalgainloststoragevalue()
/*      */     {
/*  597 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  598 */       return LostExpInfo.this.totalgainloststoragevalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAlreadygetstoragevalue()
/*      */     {
/*  605 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  606 */       return LostExpInfo.this.alreadygetstoragevalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getAlreadygainlostexp()
/*      */     {
/*  613 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  614 */       return LostExpInfo.this.alreadygainlostexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getCangainlostexp()
/*      */     {
/*  621 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  622 */       return LostExpInfo.this.cangainlostexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGaincollectexp()
/*      */     {
/*  629 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  630 */       return LostExpInfo.this.gaincollectexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBegintime()
/*      */     {
/*  637 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  638 */       return LostExpInfo.this.begintime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotalloststoragevalue(int _v_)
/*      */     {
/*  645 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  646 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotalgainloststoragevalue(int _v_)
/*      */     {
/*  653 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  654 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAlreadygetstoragevalue(int _v_)
/*      */     {
/*  661 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  662 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAlreadygainlostexp(boolean _v_)
/*      */     {
/*  669 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  670 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCangainlostexp(boolean _v_)
/*      */     {
/*  677 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  678 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGaincollectexp(int _v_)
/*      */     {
/*  685 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  686 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBegintime(long _v_)
/*      */     {
/*  693 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  694 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  700 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  701 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  707 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  708 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  714 */       return LostExpInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  720 */       return LostExpInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  726 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  727 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  733 */       return LostExpInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  739 */       return LostExpInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  745 */       LostExpInfo.this._xdb_verify_unsafe_();
/*  746 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  752 */       return LostExpInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  758 */       return LostExpInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  764 */       return LostExpInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  770 */       return LostExpInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  776 */       return LostExpInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  782 */       return LostExpInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  788 */       return LostExpInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.LostExpInfo
/*      */   {
/*      */     private int totalloststoragevalue;
/*      */     
/*      */     private int totalgainloststoragevalue;
/*      */     
/*      */     private int alreadygetstoragevalue;
/*      */     
/*      */     private boolean alreadygainlostexp;
/*      */     
/*      */     private boolean cangainlostexp;
/*      */     
/*      */     private int gaincollectexp;
/*      */     
/*      */     private long begintime;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  812 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  817 */       this.totalloststoragevalue = 0;
/*  818 */       this.totalgainloststoragevalue = 0;
/*  819 */       this.alreadygetstoragevalue = 0;
/*  820 */       this.alreadygainlostexp = false;
/*  821 */       this.cangainlostexp = false;
/*  822 */       this.gaincollectexp = 0;
/*  823 */       this.begintime = 0L;
/*      */     }
/*      */     
/*      */     Data(xbean.LostExpInfo _o1_)
/*      */     {
/*  828 */       if ((_o1_ instanceof LostExpInfo)) { assign((LostExpInfo)_o1_);
/*  829 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  830 */       } else if ((_o1_ instanceof LostExpInfo.Const)) assign(((LostExpInfo.Const)_o1_).nThis()); else {
/*  831 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(LostExpInfo _o_) {
/*  836 */       this.totalloststoragevalue = _o_.totalloststoragevalue;
/*  837 */       this.totalgainloststoragevalue = _o_.totalgainloststoragevalue;
/*  838 */       this.alreadygetstoragevalue = _o_.alreadygetstoragevalue;
/*  839 */       this.alreadygainlostexp = _o_.alreadygainlostexp;
/*  840 */       this.cangainlostexp = _o_.cangainlostexp;
/*  841 */       this.gaincollectexp = _o_.gaincollectexp;
/*  842 */       this.begintime = _o_.begintime;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  847 */       this.totalloststoragevalue = _o_.totalloststoragevalue;
/*  848 */       this.totalgainloststoragevalue = _o_.totalgainloststoragevalue;
/*  849 */       this.alreadygetstoragevalue = _o_.alreadygetstoragevalue;
/*  850 */       this.alreadygainlostexp = _o_.alreadygainlostexp;
/*  851 */       this.cangainlostexp = _o_.cangainlostexp;
/*  852 */       this.gaincollectexp = _o_.gaincollectexp;
/*  853 */       this.begintime = _o_.begintime;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  859 */       _os_.marshal(this.totalloststoragevalue);
/*  860 */       _os_.marshal(this.totalgainloststoragevalue);
/*  861 */       _os_.marshal(this.alreadygetstoragevalue);
/*  862 */       _os_.marshal(this.alreadygainlostexp);
/*  863 */       _os_.marshal(this.cangainlostexp);
/*  864 */       _os_.marshal(this.gaincollectexp);
/*  865 */       _os_.marshal(this.begintime);
/*  866 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  872 */       this.totalloststoragevalue = _os_.unmarshal_int();
/*  873 */       this.totalgainloststoragevalue = _os_.unmarshal_int();
/*  874 */       this.alreadygetstoragevalue = _os_.unmarshal_int();
/*  875 */       this.alreadygainlostexp = _os_.unmarshal_boolean();
/*  876 */       this.cangainlostexp = _os_.unmarshal_boolean();
/*  877 */       this.gaincollectexp = _os_.unmarshal_int();
/*  878 */       this.begintime = _os_.unmarshal_long();
/*  879 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  885 */       int _size_ = 0;
/*  886 */       _size_ += CodedOutputStream.computeInt32Size(1, this.totalloststoragevalue);
/*  887 */       _size_ += CodedOutputStream.computeInt32Size(2, this.totalgainloststoragevalue);
/*  888 */       _size_ += CodedOutputStream.computeInt32Size(3, this.alreadygetstoragevalue);
/*  889 */       _size_ += CodedOutputStream.computeBoolSize(4, this.alreadygainlostexp);
/*  890 */       _size_ += CodedOutputStream.computeBoolSize(5, this.cangainlostexp);
/*  891 */       _size_ += CodedOutputStream.computeInt32Size(6, this.gaincollectexp);
/*  892 */       _size_ += CodedOutputStream.computeInt64Size(7, this.begintime);
/*  893 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  901 */         _output_.writeInt32(1, this.totalloststoragevalue);
/*  902 */         _output_.writeInt32(2, this.totalgainloststoragevalue);
/*  903 */         _output_.writeInt32(3, this.alreadygetstoragevalue);
/*  904 */         _output_.writeBool(4, this.alreadygainlostexp);
/*  905 */         _output_.writeBool(5, this.cangainlostexp);
/*  906 */         _output_.writeInt32(6, this.gaincollectexp);
/*  907 */         _output_.writeInt64(7, this.begintime);
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
/*  934 */             this.totalloststoragevalue = _input_.readInt32();
/*  935 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  939 */             this.totalgainloststoragevalue = _input_.readInt32();
/*  940 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  944 */             this.alreadygetstoragevalue = _input_.readInt32();
/*  945 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  949 */             this.alreadygainlostexp = _input_.readBool();
/*  950 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  954 */             this.cangainlostexp = _input_.readBool();
/*  955 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  959 */             this.gaincollectexp = _input_.readInt32();
/*  960 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/*  964 */             this.begintime = _input_.readInt64();
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
/*      */     public xbean.LostExpInfo copy()
/*      */     {
/*  992 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LostExpInfo toData()
/*      */     {
/*  998 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.LostExpInfo toBean()
/*      */     {
/* 1003 */       return new LostExpInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.LostExpInfo toDataIf()
/*      */     {
/* 1009 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.LostExpInfo toBeanIf()
/*      */     {
/* 1014 */       return new LostExpInfo(this, null, null);
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
/*      */     public int getTotalloststoragevalue()
/*      */     {
/* 1051 */       return this.totalloststoragevalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getTotalgainloststoragevalue()
/*      */     {
/* 1058 */       return this.totalgainloststoragevalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getAlreadygetstoragevalue()
/*      */     {
/* 1065 */       return this.alreadygetstoragevalue;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getAlreadygainlostexp()
/*      */     {
/* 1072 */       return this.alreadygainlostexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getCangainlostexp()
/*      */     {
/* 1079 */       return this.cangainlostexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getGaincollectexp()
/*      */     {
/* 1086 */       return this.gaincollectexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBegintime()
/*      */     {
/* 1093 */       return this.begintime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotalloststoragevalue(int _v_)
/*      */     {
/* 1100 */       this.totalloststoragevalue = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setTotalgainloststoragevalue(int _v_)
/*      */     {
/* 1107 */       this.totalgainloststoragevalue = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAlreadygetstoragevalue(int _v_)
/*      */     {
/* 1114 */       this.alreadygetstoragevalue = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAlreadygainlostexp(boolean _v_)
/*      */     {
/* 1121 */       this.alreadygainlostexp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCangainlostexp(boolean _v_)
/*      */     {
/* 1128 */       this.cangainlostexp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGaincollectexp(int _v_)
/*      */     {
/* 1135 */       this.gaincollectexp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBegintime(long _v_)
/*      */     {
/* 1142 */       this.begintime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1148 */       if (!(_o1_ instanceof Data)) return false;
/* 1149 */       Data _o_ = (Data)_o1_;
/* 1150 */       if (this.totalloststoragevalue != _o_.totalloststoragevalue) return false;
/* 1151 */       if (this.totalgainloststoragevalue != _o_.totalgainloststoragevalue) return false;
/* 1152 */       if (this.alreadygetstoragevalue != _o_.alreadygetstoragevalue) return false;
/* 1153 */       if (this.alreadygainlostexp != _o_.alreadygainlostexp) return false;
/* 1154 */       if (this.cangainlostexp != _o_.cangainlostexp) return false;
/* 1155 */       if (this.gaincollectexp != _o_.gaincollectexp) return false;
/* 1156 */       if (this.begintime != _o_.begintime) return false;
/* 1157 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1163 */       int _h_ = 0;
/* 1164 */       _h_ += this.totalloststoragevalue;
/* 1165 */       _h_ += this.totalgainloststoragevalue;
/* 1166 */       _h_ += this.alreadygetstoragevalue;
/* 1167 */       _h_ += (this.alreadygainlostexp ? 1231 : 1237);
/* 1168 */       _h_ += (this.cangainlostexp ? 1231 : 1237);
/* 1169 */       _h_ += this.gaincollectexp;
/* 1170 */       _h_ = (int)(_h_ + this.begintime);
/* 1171 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1177 */       StringBuilder _sb_ = new StringBuilder();
/* 1178 */       _sb_.append("(");
/* 1179 */       _sb_.append(this.totalloststoragevalue);
/* 1180 */       _sb_.append(",");
/* 1181 */       _sb_.append(this.totalgainloststoragevalue);
/* 1182 */       _sb_.append(",");
/* 1183 */       _sb_.append(this.alreadygetstoragevalue);
/* 1184 */       _sb_.append(",");
/* 1185 */       _sb_.append(this.alreadygainlostexp);
/* 1186 */       _sb_.append(",");
/* 1187 */       _sb_.append(this.cangainlostexp);
/* 1188 */       _sb_.append(",");
/* 1189 */       _sb_.append(this.gaincollectexp);
/* 1190 */       _sb_.append(",");
/* 1191 */       _sb_.append(this.begintime);
/* 1192 */       _sb_.append(")");
/* 1193 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\LostExpInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */