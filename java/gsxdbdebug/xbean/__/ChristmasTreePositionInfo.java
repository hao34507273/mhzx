/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class ChristmasTreePositionInfo extends XBean implements xbean.ChristmasTreePositionInfo
/*     */ {
/*     */   private boolean canaward;
/*     */   private long hangtime;
/*     */   private long hangroleid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.canaward = false;
/*  23 */     this.hangtime = 0L;
/*  24 */     this.hangroleid = 0L;
/*     */   }
/*     */   
/*     */   ChristmasTreePositionInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public ChristmasTreePositionInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ChristmasTreePositionInfo(ChristmasTreePositionInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ChristmasTreePositionInfo(xbean.ChristmasTreePositionInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof ChristmasTreePositionInfo)) { assign((ChristmasTreePositionInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ChristmasTreePositionInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.canaward = _o_.canaward;
/*  55 */     this.hangtime = _o_.hangtime;
/*  56 */     this.hangroleid = _o_.hangroleid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.canaward = _o_.canaward;
/*  62 */     this.hangtime = _o_.hangtime;
/*  63 */     this.hangroleid = _o_.hangroleid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.canaward);
/*  71 */     _os_.marshal(this.hangtime);
/*  72 */     _os_.marshal(this.hangroleid);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.canaward = _os_.unmarshal_boolean();
/*  81 */     this.hangtime = _os_.unmarshal_long();
/*  82 */     this.hangroleid = _os_.unmarshal_long();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeBoolSize(1, this.canaward);
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(2, this.hangtime);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(3, this.hangroleid);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeBool(1, this.canaward);
/* 104 */       _output_.writeInt64(2, this.hangtime);
/* 105 */       _output_.writeInt64(3, this.hangroleid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           this.canaward = _input_.readBool();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.hangtime = _input_.readInt64();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.hangroleid = _input_.readInt64();
/* 144 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 148 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 150 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 159 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 163 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 165 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChristmasTreePositionInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new ChristmasTreePositionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChristmasTreePositionInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChristmasTreePositionInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new ChristmasTreePositionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChristmasTreePositionInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChristmasTreePositionInfo toBeanIf()
/*     */   {
/* 197 */     _xdb_verify_unsafe_();
/* 198 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getCanaward()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.canaward;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getHangtime()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.hangtime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getHangroleid()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.hangroleid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setCanaward(boolean _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "canaward")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogObject(this, Boolean.valueOf(ChristmasTreePositionInfo.this.canaward))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             ChristmasTreePositionInfo.this.canaward = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.canaward = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHangtime(long _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "hangtime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogLong(this, ChristmasTreePositionInfo.this.hangtime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             ChristmasTreePositionInfo.this.hangtime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.hangtime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setHangroleid(long _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "hangroleid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogLong(this, ChristmasTreePositionInfo.this.hangroleid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             ChristmasTreePositionInfo.this.hangroleid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.hangroleid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     ChristmasTreePositionInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof ChristmasTreePositionInfo)) { _o_ = (ChristmasTreePositionInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.canaward != _o_.canaward) return false;
/* 304 */     if (this.hangtime != _o_.hangtime) return false;
/* 305 */     if (this.hangroleid != _o_.hangroleid) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += (this.canaward ? 1231 : 1237);
/* 315 */     _h_ = (int)(_h_ + this.hangtime);
/* 316 */     _h_ = (int)(_h_ + this.hangroleid);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.canaward);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.hangtime);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.hangroleid);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("canaward"));
/* 340 */     lb.add(new ListenableChanged().setVarName("hangtime"));
/* 341 */     lb.add(new ListenableChanged().setVarName("hangroleid"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ChristmasTreePositionInfo {
/*     */     private Const() {}
/*     */     
/*     */     ChristmasTreePositionInfo nThis() {
/* 349 */       return ChristmasTreePositionInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChristmasTreePositionInfo copy()
/*     */     {
/* 361 */       return ChristmasTreePositionInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChristmasTreePositionInfo toData()
/*     */     {
/* 367 */       return ChristmasTreePositionInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ChristmasTreePositionInfo toBean()
/*     */     {
/* 372 */       return ChristmasTreePositionInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChristmasTreePositionInfo toDataIf()
/*     */     {
/* 378 */       return ChristmasTreePositionInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ChristmasTreePositionInfo toBeanIf()
/*     */     {
/* 383 */       return ChristmasTreePositionInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getCanaward()
/*     */     {
/* 390 */       ChristmasTreePositionInfo.this._xdb_verify_unsafe_();
/* 391 */       return ChristmasTreePositionInfo.this.canaward;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getHangtime()
/*     */     {
/* 398 */       ChristmasTreePositionInfo.this._xdb_verify_unsafe_();
/* 399 */       return ChristmasTreePositionInfo.this.hangtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getHangroleid()
/*     */     {
/* 406 */       ChristmasTreePositionInfo.this._xdb_verify_unsafe_();
/* 407 */       return ChristmasTreePositionInfo.this.hangroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCanaward(boolean _v_)
/*     */     {
/* 414 */       ChristmasTreePositionInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHangtime(long _v_)
/*     */     {
/* 422 */       ChristmasTreePositionInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHangroleid(long _v_)
/*     */     {
/* 430 */       ChristmasTreePositionInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       ChristmasTreePositionInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       ChristmasTreePositionInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return ChristmasTreePositionInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return ChristmasTreePositionInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       ChristmasTreePositionInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return ChristmasTreePositionInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return ChristmasTreePositionInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       ChristmasTreePositionInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return ChristmasTreePositionInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return ChristmasTreePositionInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return ChristmasTreePositionInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return ChristmasTreePositionInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return ChristmasTreePositionInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return ChristmasTreePositionInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return ChristmasTreePositionInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ChristmasTreePositionInfo
/*     */   {
/*     */     private boolean canaward;
/*     */     
/*     */     private long hangtime;
/*     */     
/*     */     private long hangroleid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 541 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.ChristmasTreePositionInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof ChristmasTreePositionInfo)) { assign((ChristmasTreePositionInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof ChristmasTreePositionInfo.Const)) assign(((ChristmasTreePositionInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ChristmasTreePositionInfo _o_) {
/* 558 */       this.canaward = _o_.canaward;
/* 559 */       this.hangtime = _o_.hangtime;
/* 560 */       this.hangroleid = _o_.hangroleid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.canaward = _o_.canaward;
/* 566 */       this.hangtime = _o_.hangtime;
/* 567 */       this.hangroleid = _o_.hangroleid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.canaward);
/* 574 */       _os_.marshal(this.hangtime);
/* 575 */       _os_.marshal(this.hangroleid);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.canaward = _os_.unmarshal_boolean();
/* 583 */       this.hangtime = _os_.unmarshal_long();
/* 584 */       this.hangroleid = _os_.unmarshal_long();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeBoolSize(1, this.canaward);
/* 593 */       _size_ += CodedOutputStream.computeInt64Size(2, this.hangtime);
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(3, this.hangroleid);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeBool(1, this.canaward);
/* 604 */         _output_.writeInt64(2, this.hangtime);
/* 605 */         _output_.writeInt64(3, this.hangroleid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 609 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 611 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 619 */         boolean done = false;
/* 620 */         while (!done)
/*     */         {
/* 622 */           int tag = _input_.readTag();
/* 623 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 627 */             done = true;
/* 628 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 632 */             this.canaward = _input_.readBool();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.hangtime = _input_.readInt64();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.hangroleid = _input_.readInt64();
/* 643 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 647 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 649 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 658 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 662 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 664 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChristmasTreePositionInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChristmasTreePositionInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ChristmasTreePositionInfo toBean()
/*     */     {
/* 681 */       return new ChristmasTreePositionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChristmasTreePositionInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ChristmasTreePositionInfo toBeanIf()
/*     */     {
/* 692 */       return new ChristmasTreePositionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 698 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 702 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 706 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 710 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 714 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 718 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 722 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getCanaward()
/*     */     {
/* 729 */       return this.canaward;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getHangtime()
/*     */     {
/* 736 */       return this.hangtime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getHangroleid()
/*     */     {
/* 743 */       return this.hangroleid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setCanaward(boolean _v_)
/*     */     {
/* 750 */       this.canaward = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHangtime(long _v_)
/*     */     {
/* 757 */       this.hangtime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setHangroleid(long _v_)
/*     */     {
/* 764 */       this.hangroleid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.canaward != _o_.canaward) return false;
/* 773 */       if (this.hangtime != _o_.hangtime) return false;
/* 774 */       if (this.hangroleid != _o_.hangroleid) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += (this.canaward ? 1231 : 1237);
/* 783 */       _h_ = (int)(_h_ + this.hangtime);
/* 784 */       _h_ = (int)(_h_ + this.hangroleid);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.canaward);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.hangtime);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.hangroleid);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChristmasTreePositionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */