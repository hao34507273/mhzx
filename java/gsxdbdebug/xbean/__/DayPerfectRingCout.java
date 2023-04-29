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
/*      */ 
/*      */ public final class DayPerfectRingCout extends XBean implements xbean.DayPerfectRingCout
/*      */ {
/*      */   private boolean hasgiveup;
/*      */   private int currentring;
/*      */   private long cleantime;
/*      */   private int shimencount;
/*      */   private int reservedexp;
/*      */   private int exchangecount;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.hasgiveup = false;
/*   29 */     this.currentring = 0;
/*   30 */     this.cleantime = 0L;
/*   31 */     this.shimencount = 0;
/*   32 */     this.reservedexp = 0;
/*   33 */     this.exchangecount = 0;
/*      */   }
/*      */   
/*      */   DayPerfectRingCout(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.hasgiveup = false;
/*   40 */     this.currentring = 0;
/*   41 */     this.shimencount = 0;
/*   42 */     this.reservedexp = 0;
/*   43 */     this.exchangecount = 0;
/*      */   }
/*      */   
/*      */   public DayPerfectRingCout()
/*      */   {
/*   48 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public DayPerfectRingCout(DayPerfectRingCout _o_)
/*      */   {
/*   53 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   DayPerfectRingCout(xbean.DayPerfectRingCout _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   58 */     super(_xp_, _vn_);
/*   59 */     if ((_o1_ instanceof DayPerfectRingCout)) { assign((DayPerfectRingCout)_o1_);
/*   60 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   61 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   62 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(DayPerfectRingCout _o_) {
/*   67 */     _o_._xdb_verify_unsafe_();
/*   68 */     this.hasgiveup = _o_.hasgiveup;
/*   69 */     this.currentring = _o_.currentring;
/*   70 */     this.cleantime = _o_.cleantime;
/*   71 */     this.shimencount = _o_.shimencount;
/*   72 */     this.reservedexp = _o_.reservedexp;
/*   73 */     this.exchangecount = _o_.exchangecount;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   78 */     this.hasgiveup = _o_.hasgiveup;
/*   79 */     this.currentring = _o_.currentring;
/*   80 */     this.cleantime = _o_.cleantime;
/*   81 */     this.shimencount = _o_.shimencount;
/*   82 */     this.reservedexp = _o_.reservedexp;
/*   83 */     this.exchangecount = _o_.exchangecount;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   89 */     _xdb_verify_unsafe_();
/*   90 */     _os_.marshal(this.hasgiveup);
/*   91 */     _os_.marshal(this.currentring);
/*   92 */     _os_.marshal(this.cleantime);
/*   93 */     _os_.marshal(this.shimencount);
/*   94 */     _os_.marshal(this.reservedexp);
/*   95 */     _os_.marshal(this.exchangecount);
/*   96 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  102 */     _xdb_verify_unsafe_();
/*  103 */     this.hasgiveup = _os_.unmarshal_boolean();
/*  104 */     this.currentring = _os_.unmarshal_int();
/*  105 */     this.cleantime = _os_.unmarshal_long();
/*  106 */     this.shimencount = _os_.unmarshal_int();
/*  107 */     this.reservedexp = _os_.unmarshal_int();
/*  108 */     this.exchangecount = _os_.unmarshal_int();
/*  109 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  115 */     _xdb_verify_unsafe_();
/*  116 */     int _size_ = 0;
/*  117 */     _size_ += CodedOutputStream.computeBoolSize(1, this.hasgiveup);
/*  118 */     _size_ += CodedOutputStream.computeInt32Size(2, this.currentring);
/*  119 */     _size_ += CodedOutputStream.computeInt64Size(3, this.cleantime);
/*  120 */     _size_ += CodedOutputStream.computeInt32Size(4, this.shimencount);
/*  121 */     _size_ += CodedOutputStream.computeInt32Size(5, this.reservedexp);
/*  122 */     _size_ += CodedOutputStream.computeInt32Size(6, this.exchangecount);
/*  123 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  129 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  132 */       _output_.writeBool(1, this.hasgiveup);
/*  133 */       _output_.writeInt32(2, this.currentring);
/*  134 */       _output_.writeInt64(3, this.cleantime);
/*  135 */       _output_.writeInt32(4, this.shimencount);
/*  136 */       _output_.writeInt32(5, this.reservedexp);
/*  137 */       _output_.writeInt32(6, this.exchangecount);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  141 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  143 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  149 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  152 */       boolean done = false;
/*  153 */       while (!done)
/*      */       {
/*  155 */         int tag = _input_.readTag();
/*  156 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  160 */           done = true;
/*  161 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  165 */           this.hasgiveup = _input_.readBool();
/*  166 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  170 */           this.currentring = _input_.readInt32();
/*  171 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  175 */           this.cleantime = _input_.readInt64();
/*  176 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  180 */           this.shimencount = _input_.readInt32();
/*  181 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  185 */           this.reservedexp = _input_.readInt32();
/*  186 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  190 */           this.exchangecount = _input_.readInt32();
/*  191 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  195 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  197 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  206 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  210 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  212 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DayPerfectRingCout copy()
/*      */   {
/*  218 */     _xdb_verify_unsafe_();
/*  219 */     return new DayPerfectRingCout(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DayPerfectRingCout toData()
/*      */   {
/*  225 */     _xdb_verify_unsafe_();
/*  226 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.DayPerfectRingCout toBean()
/*      */   {
/*  231 */     _xdb_verify_unsafe_();
/*  232 */     return new DayPerfectRingCout(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.DayPerfectRingCout toDataIf()
/*      */   {
/*  238 */     _xdb_verify_unsafe_();
/*  239 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.DayPerfectRingCout toBeanIf()
/*      */   {
/*  244 */     _xdb_verify_unsafe_();
/*  245 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public Bean toConst()
/*      */   {
/*  251 */     _xdb_verify_unsafe_();
/*  252 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public boolean getHasgiveup()
/*      */   {
/*  259 */     _xdb_verify_unsafe_();
/*  260 */     return this.hasgiveup;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getCurrentring()
/*      */   {
/*  267 */     _xdb_verify_unsafe_();
/*  268 */     return this.currentring;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCleantime()
/*      */   {
/*  275 */     _xdb_verify_unsafe_();
/*  276 */     return this.cleantime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getShimencount()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return this.shimencount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getReservedexp()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return this.reservedexp;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getExchangecount()
/*      */   {
/*  299 */     _xdb_verify_unsafe_();
/*  300 */     return this.exchangecount;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setHasgiveup(boolean _v_)
/*      */   {
/*  307 */     _xdb_verify_unsafe_();
/*  308 */     Logs.logIf(new LogKey(this, "hasgiveup")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  312 */         new xdb.logs.LogObject(this, Boolean.valueOf(DayPerfectRingCout.this.hasgiveup))
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  316 */             DayPerfectRingCout.this.hasgiveup = ((Boolean)this._xdb_saved).booleanValue();
/*      */           }
/*      */         };
/*      */       }
/*  320 */     });
/*  321 */     this.hasgiveup = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCurrentring(int _v_)
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     Logs.logIf(new LogKey(this, "currentring")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  333 */         new LogInt(this, DayPerfectRingCout.this.currentring)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  337 */             DayPerfectRingCout.this.currentring = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  341 */     });
/*  342 */     this.currentring = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCleantime(long _v_)
/*      */   {
/*  349 */     _xdb_verify_unsafe_();
/*  350 */     Logs.logIf(new LogKey(this, "cleantime")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  354 */         new xdb.logs.LogLong(this, DayPerfectRingCout.this.cleantime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  358 */             DayPerfectRingCout.this.cleantime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  362 */     });
/*  363 */     this.cleantime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setShimencount(int _v_)
/*      */   {
/*  370 */     _xdb_verify_unsafe_();
/*  371 */     Logs.logIf(new LogKey(this, "shimencount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  375 */         new LogInt(this, DayPerfectRingCout.this.shimencount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  379 */             DayPerfectRingCout.this.shimencount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  383 */     });
/*  384 */     this.shimencount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReservedexp(int _v_)
/*      */   {
/*  391 */     _xdb_verify_unsafe_();
/*  392 */     Logs.logIf(new LogKey(this, "reservedexp")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  396 */         new LogInt(this, DayPerfectRingCout.this.reservedexp)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  400 */             DayPerfectRingCout.this.reservedexp = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  404 */     });
/*  405 */     this.reservedexp = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setExchangecount(int _v_)
/*      */   {
/*  412 */     _xdb_verify_unsafe_();
/*  413 */     Logs.logIf(new LogKey(this, "exchangecount")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  417 */         new LogInt(this, DayPerfectRingCout.this.exchangecount)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  421 */             DayPerfectRingCout.this.exchangecount = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  425 */     });
/*  426 */     this.exchangecount = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  432 */     _xdb_verify_unsafe_();
/*  433 */     DayPerfectRingCout _o_ = null;
/*  434 */     if ((_o1_ instanceof DayPerfectRingCout)) { _o_ = (DayPerfectRingCout)_o1_;
/*  435 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  436 */       return false;
/*  437 */     if (this.hasgiveup != _o_.hasgiveup) return false;
/*  438 */     if (this.currentring != _o_.currentring) return false;
/*  439 */     if (this.cleantime != _o_.cleantime) return false;
/*  440 */     if (this.shimencount != _o_.shimencount) return false;
/*  441 */     if (this.reservedexp != _o_.reservedexp) return false;
/*  442 */     if (this.exchangecount != _o_.exchangecount) return false;
/*  443 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*  450 */     int _h_ = 0;
/*  451 */     _h_ += (this.hasgiveup ? 1231 : 1237);
/*  452 */     _h_ += this.currentring;
/*  453 */     _h_ = (int)(_h_ + this.cleantime);
/*  454 */     _h_ += this.shimencount;
/*  455 */     _h_ += this.reservedexp;
/*  456 */     _h_ += this.exchangecount;
/*  457 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  463 */     _xdb_verify_unsafe_();
/*  464 */     StringBuilder _sb_ = new StringBuilder();
/*  465 */     _sb_.append("(");
/*  466 */     _sb_.append(this.hasgiveup);
/*  467 */     _sb_.append(",");
/*  468 */     _sb_.append(this.currentring);
/*  469 */     _sb_.append(",");
/*  470 */     _sb_.append(this.cleantime);
/*  471 */     _sb_.append(",");
/*  472 */     _sb_.append(this.shimencount);
/*  473 */     _sb_.append(",");
/*  474 */     _sb_.append(this.reservedexp);
/*  475 */     _sb_.append(",");
/*  476 */     _sb_.append(this.exchangecount);
/*  477 */     _sb_.append(")");
/*  478 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  484 */     ListenableBean lb = new ListenableBean();
/*  485 */     lb.add(new ListenableChanged().setVarName("hasgiveup"));
/*  486 */     lb.add(new ListenableChanged().setVarName("currentring"));
/*  487 */     lb.add(new ListenableChanged().setVarName("cleantime"));
/*  488 */     lb.add(new ListenableChanged().setVarName("shimencount"));
/*  489 */     lb.add(new ListenableChanged().setVarName("reservedexp"));
/*  490 */     lb.add(new ListenableChanged().setVarName("exchangecount"));
/*  491 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.DayPerfectRingCout {
/*      */     private Const() {}
/*      */     
/*      */     DayPerfectRingCout nThis() {
/*  498 */       return DayPerfectRingCout.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  504 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DayPerfectRingCout copy()
/*      */     {
/*  510 */       return DayPerfectRingCout.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DayPerfectRingCout toData()
/*      */     {
/*  516 */       return DayPerfectRingCout.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.DayPerfectRingCout toBean()
/*      */     {
/*  521 */       return DayPerfectRingCout.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DayPerfectRingCout toDataIf()
/*      */     {
/*  527 */       return DayPerfectRingCout.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.DayPerfectRingCout toBeanIf()
/*      */     {
/*  532 */       return DayPerfectRingCout.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHasgiveup()
/*      */     {
/*  539 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  540 */       return DayPerfectRingCout.this.hasgiveup;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrentring()
/*      */     {
/*  547 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  548 */       return DayPerfectRingCout.this.currentring;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCleantime()
/*      */     {
/*  555 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  556 */       return DayPerfectRingCout.this.cleantime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getShimencount()
/*      */     {
/*  563 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  564 */       return DayPerfectRingCout.this.shimencount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReservedexp()
/*      */     {
/*  571 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  572 */       return DayPerfectRingCout.this.reservedexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExchangecount()
/*      */     {
/*  579 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  580 */       return DayPerfectRingCout.this.exchangecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHasgiveup(boolean _v_)
/*      */     {
/*  587 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  588 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrentring(int _v_)
/*      */     {
/*  595 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  596 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCleantime(long _v_)
/*      */     {
/*  603 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  604 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShimencount(int _v_)
/*      */     {
/*  611 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  612 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReservedexp(int _v_)
/*      */     {
/*  619 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  620 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExchangecount(int _v_)
/*      */     {
/*  627 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  628 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean toConst()
/*      */     {
/*  634 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  635 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  641 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  642 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  648 */       return DayPerfectRingCout.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  654 */       return DayPerfectRingCout.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  660 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  661 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  667 */       return DayPerfectRingCout.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  673 */       return DayPerfectRingCout.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  679 */       DayPerfectRingCout.this._xdb_verify_unsafe_();
/*  680 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public Bean xdbParent()
/*      */     {
/*  686 */       return DayPerfectRingCout.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  692 */       return DayPerfectRingCout.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  698 */       return DayPerfectRingCout.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  704 */       return DayPerfectRingCout.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  710 */       return DayPerfectRingCout.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  716 */       return DayPerfectRingCout.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  722 */       return DayPerfectRingCout.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.DayPerfectRingCout
/*      */   {
/*      */     private boolean hasgiveup;
/*      */     
/*      */     private int currentring;
/*      */     
/*      */     private long cleantime;
/*      */     
/*      */     private int shimencount;
/*      */     
/*      */     private int reservedexp;
/*      */     
/*      */     private int exchangecount;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  744 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  749 */       this.hasgiveup = false;
/*  750 */       this.currentring = 0;
/*  751 */       this.shimencount = 0;
/*  752 */       this.reservedexp = 0;
/*  753 */       this.exchangecount = 0;
/*      */     }
/*      */     
/*      */     Data(xbean.DayPerfectRingCout _o1_)
/*      */     {
/*  758 */       if ((_o1_ instanceof DayPerfectRingCout)) { assign((DayPerfectRingCout)_o1_);
/*  759 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  760 */       } else if ((_o1_ instanceof DayPerfectRingCout.Const)) assign(((DayPerfectRingCout.Const)_o1_).nThis()); else {
/*  761 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(DayPerfectRingCout _o_) {
/*  766 */       this.hasgiveup = _o_.hasgiveup;
/*  767 */       this.currentring = _o_.currentring;
/*  768 */       this.cleantime = _o_.cleantime;
/*  769 */       this.shimencount = _o_.shimencount;
/*  770 */       this.reservedexp = _o_.reservedexp;
/*  771 */       this.exchangecount = _o_.exchangecount;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  776 */       this.hasgiveup = _o_.hasgiveup;
/*  777 */       this.currentring = _o_.currentring;
/*  778 */       this.cleantime = _o_.cleantime;
/*  779 */       this.shimencount = _o_.shimencount;
/*  780 */       this.reservedexp = _o_.reservedexp;
/*  781 */       this.exchangecount = _o_.exchangecount;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  787 */       _os_.marshal(this.hasgiveup);
/*  788 */       _os_.marshal(this.currentring);
/*  789 */       _os_.marshal(this.cleantime);
/*  790 */       _os_.marshal(this.shimencount);
/*  791 */       _os_.marshal(this.reservedexp);
/*  792 */       _os_.marshal(this.exchangecount);
/*  793 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  799 */       this.hasgiveup = _os_.unmarshal_boolean();
/*  800 */       this.currentring = _os_.unmarshal_int();
/*  801 */       this.cleantime = _os_.unmarshal_long();
/*  802 */       this.shimencount = _os_.unmarshal_int();
/*  803 */       this.reservedexp = _os_.unmarshal_int();
/*  804 */       this.exchangecount = _os_.unmarshal_int();
/*  805 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  811 */       int _size_ = 0;
/*  812 */       _size_ += CodedOutputStream.computeBoolSize(1, this.hasgiveup);
/*  813 */       _size_ += CodedOutputStream.computeInt32Size(2, this.currentring);
/*  814 */       _size_ += CodedOutputStream.computeInt64Size(3, this.cleantime);
/*  815 */       _size_ += CodedOutputStream.computeInt32Size(4, this.shimencount);
/*  816 */       _size_ += CodedOutputStream.computeInt32Size(5, this.reservedexp);
/*  817 */       _size_ += CodedOutputStream.computeInt32Size(6, this.exchangecount);
/*  818 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  826 */         _output_.writeBool(1, this.hasgiveup);
/*  827 */         _output_.writeInt32(2, this.currentring);
/*  828 */         _output_.writeInt64(3, this.cleantime);
/*  829 */         _output_.writeInt32(4, this.shimencount);
/*  830 */         _output_.writeInt32(5, this.reservedexp);
/*  831 */         _output_.writeInt32(6, this.exchangecount);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  835 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  837 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  845 */         boolean done = false;
/*  846 */         while (!done)
/*      */         {
/*  848 */           int tag = _input_.readTag();
/*  849 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/*  853 */             done = true;
/*  854 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/*  858 */             this.hasgiveup = _input_.readBool();
/*  859 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/*  863 */             this.currentring = _input_.readInt32();
/*  864 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/*  868 */             this.cleantime = _input_.readInt64();
/*  869 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/*  873 */             this.shimencount = _input_.readInt32();
/*  874 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/*  878 */             this.reservedexp = _input_.readInt32();
/*  879 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/*  883 */             this.exchangecount = _input_.readInt32();
/*  884 */             break;
/*      */           
/*      */ 
/*      */           default: 
/*  888 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/*  890 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/*  899 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  903 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  905 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DayPerfectRingCout copy()
/*      */     {
/*  911 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DayPerfectRingCout toData()
/*      */     {
/*  917 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.DayPerfectRingCout toBean()
/*      */     {
/*  922 */       return new DayPerfectRingCout(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.DayPerfectRingCout toDataIf()
/*      */     {
/*  928 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.DayPerfectRingCout toBeanIf()
/*      */     {
/*  933 */       return new DayPerfectRingCout(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  939 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean xdbParent() {
/*  943 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/*  947 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/*  951 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Bean toConst() {
/*  955 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/*  959 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/*  963 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public boolean getHasgiveup()
/*      */     {
/*  970 */       return this.hasgiveup;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getCurrentring()
/*      */     {
/*  977 */       return this.currentring;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCleantime()
/*      */     {
/*  984 */       return this.cleantime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getShimencount()
/*      */     {
/*  991 */       return this.shimencount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReservedexp()
/*      */     {
/*  998 */       return this.reservedexp;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getExchangecount()
/*      */     {
/* 1005 */       return this.exchangecount;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setHasgiveup(boolean _v_)
/*      */     {
/* 1012 */       this.hasgiveup = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCurrentring(int _v_)
/*      */     {
/* 1019 */       this.currentring = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCleantime(long _v_)
/*      */     {
/* 1026 */       this.cleantime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setShimencount(int _v_)
/*      */     {
/* 1033 */       this.shimencount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReservedexp(int _v_)
/*      */     {
/* 1040 */       this.reservedexp = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setExchangecount(int _v_)
/*      */     {
/* 1047 */       this.exchangecount = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1053 */       if (!(_o1_ instanceof Data)) return false;
/* 1054 */       Data _o_ = (Data)_o1_;
/* 1055 */       if (this.hasgiveup != _o_.hasgiveup) return false;
/* 1056 */       if (this.currentring != _o_.currentring) return false;
/* 1057 */       if (this.cleantime != _o_.cleantime) return false;
/* 1058 */       if (this.shimencount != _o_.shimencount) return false;
/* 1059 */       if (this.reservedexp != _o_.reservedexp) return false;
/* 1060 */       if (this.exchangecount != _o_.exchangecount) return false;
/* 1061 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1067 */       int _h_ = 0;
/* 1068 */       _h_ += (this.hasgiveup ? 1231 : 1237);
/* 1069 */       _h_ += this.currentring;
/* 1070 */       _h_ = (int)(_h_ + this.cleantime);
/* 1071 */       _h_ += this.shimencount;
/* 1072 */       _h_ += this.reservedexp;
/* 1073 */       _h_ += this.exchangecount;
/* 1074 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1080 */       StringBuilder _sb_ = new StringBuilder();
/* 1081 */       _sb_.append("(");
/* 1082 */       _sb_.append(this.hasgiveup);
/* 1083 */       _sb_.append(",");
/* 1084 */       _sb_.append(this.currentring);
/* 1085 */       _sb_.append(",");
/* 1086 */       _sb_.append(this.cleantime);
/* 1087 */       _sb_.append(",");
/* 1088 */       _sb_.append(this.shimencount);
/* 1089 */       _sb_.append(",");
/* 1090 */       _sb_.append(this.reservedexp);
/* 1091 */       _sb_.append(",");
/* 1092 */       _sb_.append(this.exchangecount);
/* 1093 */       _sb_.append(")");
/* 1094 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\DayPerfectRingCout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */