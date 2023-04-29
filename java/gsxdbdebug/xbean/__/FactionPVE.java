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
/*     */ public final class FactionPVE extends XBean implements xbean.FactionPVE
/*     */ {
/*     */   private int activate_times;
/*     */   private int set_times;
/*     */   private long start_timestamp;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.activate_times = 0;
/*  23 */     this.set_times = 0;
/*  24 */     this.start_timestamp = 0L;
/*     */   }
/*     */   
/*     */   FactionPVE(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public FactionPVE()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public FactionPVE(FactionPVE _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   FactionPVE(xbean.FactionPVE _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof FactionPVE)) { assign((FactionPVE)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(FactionPVE _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.activate_times = _o_.activate_times;
/*  55 */     this.set_times = _o_.set_times;
/*  56 */     this.start_timestamp = _o_.start_timestamp;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.activate_times = _o_.activate_times;
/*  62 */     this.set_times = _o_.set_times;
/*  63 */     this.start_timestamp = _o_.start_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.activate_times);
/*  71 */     _os_.marshal(this.set_times);
/*  72 */     _os_.marshal(this.start_timestamp);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.activate_times = _os_.unmarshal_int();
/*  81 */     this.set_times = _os_.unmarshal_int();
/*  82 */     this.start_timestamp = _os_.unmarshal_long();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.activate_times);
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(2, this.set_times);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(3, this.start_timestamp);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.activate_times);
/* 104 */       _output_.writeInt32(2, this.set_times);
/* 105 */       _output_.writeInt64(3, this.start_timestamp);
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
/* 133 */           this.activate_times = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.set_times = _input_.readInt32();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.start_timestamp = _input_.readInt64();
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
/*     */   public xbean.FactionPVE copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new FactionPVE(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FactionPVE toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FactionPVE toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new FactionPVE(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.FactionPVE toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.FactionPVE toBeanIf()
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
/*     */   public int getActivate_times()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.activate_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getSet_times()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.set_times;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStart_timestamp()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.start_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setActivate_times(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "activate_times")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, FactionPVE.this.activate_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             FactionPVE.this.activate_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.activate_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setSet_times(int _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "set_times")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogInt(this, FactionPVE.this.set_times)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             FactionPVE.this.set_times = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.set_times = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStart_timestamp(long _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "start_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogLong(this, FactionPVE.this.start_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             FactionPVE.this.start_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.start_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     FactionPVE _o_ = null;
/* 300 */     if ((_o1_ instanceof FactionPVE)) { _o_ = (FactionPVE)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.activate_times != _o_.activate_times) return false;
/* 304 */     if (this.set_times != _o_.set_times) return false;
/* 305 */     if (this.start_timestamp != _o_.start_timestamp) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.activate_times;
/* 315 */     _h_ += this.set_times;
/* 316 */     _h_ = (int)(_h_ + this.start_timestamp);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.activate_times);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.set_times);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.start_timestamp);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("activate_times"));
/* 340 */     lb.add(new ListenableChanged().setVarName("set_times"));
/* 341 */     lb.add(new ListenableChanged().setVarName("start_timestamp"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.FactionPVE {
/*     */     private Const() {}
/*     */     
/*     */     FactionPVE nThis() {
/* 349 */       return FactionPVE.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionPVE copy()
/*     */     {
/* 361 */       return FactionPVE.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionPVE toData()
/*     */     {
/* 367 */       return FactionPVE.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.FactionPVE toBean()
/*     */     {
/* 372 */       return FactionPVE.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionPVE toDataIf()
/*     */     {
/* 378 */       return FactionPVE.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.FactionPVE toBeanIf()
/*     */     {
/* 383 */       return FactionPVE.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getActivate_times()
/*     */     {
/* 390 */       FactionPVE.this._xdb_verify_unsafe_();
/* 391 */       return FactionPVE.this.activate_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSet_times()
/*     */     {
/* 398 */       FactionPVE.this._xdb_verify_unsafe_();
/* 399 */       return FactionPVE.this.set_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_timestamp()
/*     */     {
/* 406 */       FactionPVE.this._xdb_verify_unsafe_();
/* 407 */       return FactionPVE.this.start_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActivate_times(int _v_)
/*     */     {
/* 414 */       FactionPVE.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSet_times(int _v_)
/*     */     {
/* 422 */       FactionPVE.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_timestamp(long _v_)
/*     */     {
/* 430 */       FactionPVE.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       FactionPVE.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       FactionPVE.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return FactionPVE.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return FactionPVE.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       FactionPVE.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return FactionPVE.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return FactionPVE.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       FactionPVE.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return FactionPVE.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return FactionPVE.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return FactionPVE.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return FactionPVE.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return FactionPVE.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return FactionPVE.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return FactionPVE.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.FactionPVE
/*     */   {
/*     */     private int activate_times;
/*     */     
/*     */     private int set_times;
/*     */     
/*     */     private long start_timestamp;
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
/*     */     Data(xbean.FactionPVE _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof FactionPVE)) { assign((FactionPVE)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof FactionPVE.Const)) assign(((FactionPVE.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(FactionPVE _o_) {
/* 558 */       this.activate_times = _o_.activate_times;
/* 559 */       this.set_times = _o_.set_times;
/* 560 */       this.start_timestamp = _o_.start_timestamp;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.activate_times = _o_.activate_times;
/* 566 */       this.set_times = _o_.set_times;
/* 567 */       this.start_timestamp = _o_.start_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.activate_times);
/* 574 */       _os_.marshal(this.set_times);
/* 575 */       _os_.marshal(this.start_timestamp);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.activate_times = _os_.unmarshal_int();
/* 583 */       this.set_times = _os_.unmarshal_int();
/* 584 */       this.start_timestamp = _os_.unmarshal_long();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.activate_times);
/* 593 */       _size_ += CodedOutputStream.computeInt32Size(2, this.set_times);
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(3, this.start_timestamp);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.activate_times);
/* 604 */         _output_.writeInt32(2, this.set_times);
/* 605 */         _output_.writeInt64(3, this.start_timestamp);
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
/* 632 */             this.activate_times = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.set_times = _input_.readInt32();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.start_timestamp = _input_.readInt64();
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
/*     */     public xbean.FactionPVE copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionPVE toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.FactionPVE toBean()
/*     */     {
/* 681 */       return new FactionPVE(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.FactionPVE toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.FactionPVE toBeanIf()
/*     */     {
/* 692 */       return new FactionPVE(this, null, null);
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
/*     */     public int getActivate_times()
/*     */     {
/* 729 */       return this.activate_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getSet_times()
/*     */     {
/* 736 */       return this.set_times;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStart_timestamp()
/*     */     {
/* 743 */       return this.start_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setActivate_times(int _v_)
/*     */     {
/* 750 */       this.activate_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setSet_times(int _v_)
/*     */     {
/* 757 */       this.set_times = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStart_timestamp(long _v_)
/*     */     {
/* 764 */       this.start_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.activate_times != _o_.activate_times) return false;
/* 773 */       if (this.set_times != _o_.set_times) return false;
/* 774 */       if (this.start_timestamp != _o_.start_timestamp) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.activate_times;
/* 783 */       _h_ += this.set_times;
/* 784 */       _h_ = (int)(_h_ + this.start_timestamp);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.activate_times);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.set_times);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.start_timestamp);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\FactionPVE.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */