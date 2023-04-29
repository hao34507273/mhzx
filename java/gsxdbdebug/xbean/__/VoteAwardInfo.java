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
/*     */ public final class VoteAwardInfo extends XBean implements xbean.VoteAwardInfo
/*     */ {
/*     */   private int award;
/*     */   private int num;
/*     */   private long last_time;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.award = 0;
/*  23 */     this.num = 0;
/*  24 */     this.last_time = 0L;
/*     */   }
/*     */   
/*     */   VoteAwardInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public VoteAwardInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public VoteAwardInfo(VoteAwardInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   VoteAwardInfo(xbean.VoteAwardInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof VoteAwardInfo)) { assign((VoteAwardInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(VoteAwardInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.award = _o_.award;
/*  55 */     this.num = _o_.num;
/*  56 */     this.last_time = _o_.last_time;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.award = _o_.award;
/*  62 */     this.num = _o_.num;
/*  63 */     this.last_time = _o_.last_time;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.award);
/*  71 */     _os_.marshal(this.num);
/*  72 */     _os_.marshal(this.last_time);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.award = _os_.unmarshal_int();
/*  81 */     this.num = _os_.unmarshal_int();
/*  82 */     this.last_time = _os_.unmarshal_long();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.award);
/*  92 */     _size_ += CodedOutputStream.computeInt32Size(2, this.num);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(3, this.last_time);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.award);
/* 104 */       _output_.writeInt32(2, this.num);
/* 105 */       _output_.writeInt64(3, this.last_time);
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
/* 133 */           this.award = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.num = _input_.readInt32();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.last_time = _input_.readInt64();
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
/*     */   public xbean.VoteAwardInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new VoteAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.VoteAwardInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.VoteAwardInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new VoteAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.VoteAwardInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.VoteAwardInfo toBeanIf()
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
/*     */   public int getAward()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.award;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNum()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getLast_time()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.last_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAward(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "award")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, VoteAwardInfo.this.award)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             VoteAwardInfo.this.award = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.award = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNum(int _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogInt(this, VoteAwardInfo.this.num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             VoteAwardInfo.this.num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLast_time(long _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "last_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogLong(this, VoteAwardInfo.this.last_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             VoteAwardInfo.this.last_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.last_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     VoteAwardInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof VoteAwardInfo)) { _o_ = (VoteAwardInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.award != _o_.award) return false;
/* 304 */     if (this.num != _o_.num) return false;
/* 305 */     if (this.last_time != _o_.last_time) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.award;
/* 315 */     _h_ += this.num;
/* 316 */     _h_ = (int)(_h_ + this.last_time);
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.award);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.num);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.last_time);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("award"));
/* 340 */     lb.add(new ListenableChanged().setVarName("num"));
/* 341 */     lb.add(new ListenableChanged().setVarName("last_time"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.VoteAwardInfo {
/*     */     private Const() {}
/*     */     
/*     */     VoteAwardInfo nThis() {
/* 349 */       return VoteAwardInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoteAwardInfo copy()
/*     */     {
/* 361 */       return VoteAwardInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoteAwardInfo toData()
/*     */     {
/* 367 */       return VoteAwardInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.VoteAwardInfo toBean()
/*     */     {
/* 372 */       return VoteAwardInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoteAwardInfo toDataIf()
/*     */     {
/* 378 */       return VoteAwardInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.VoteAwardInfo toBeanIf()
/*     */     {
/* 383 */       return VoteAwardInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAward()
/*     */     {
/* 390 */       VoteAwardInfo.this._xdb_verify_unsafe_();
/* 391 */       return VoteAwardInfo.this.award;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNum()
/*     */     {
/* 398 */       VoteAwardInfo.this._xdb_verify_unsafe_();
/* 399 */       return VoteAwardInfo.this.num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_time()
/*     */     {
/* 406 */       VoteAwardInfo.this._xdb_verify_unsafe_();
/* 407 */       return VoteAwardInfo.this.last_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward(int _v_)
/*     */     {
/* 414 */       VoteAwardInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNum(int _v_)
/*     */     {
/* 422 */       VoteAwardInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_time(long _v_)
/*     */     {
/* 430 */       VoteAwardInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       VoteAwardInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       VoteAwardInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return VoteAwardInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return VoteAwardInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       VoteAwardInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return VoteAwardInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return VoteAwardInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       VoteAwardInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return VoteAwardInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return VoteAwardInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return VoteAwardInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return VoteAwardInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return VoteAwardInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return VoteAwardInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return VoteAwardInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.VoteAwardInfo
/*     */   {
/*     */     private int award;
/*     */     
/*     */     private int num;
/*     */     
/*     */     private long last_time;
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
/*     */     Data(xbean.VoteAwardInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof VoteAwardInfo)) { assign((VoteAwardInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof VoteAwardInfo.Const)) assign(((VoteAwardInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(VoteAwardInfo _o_) {
/* 558 */       this.award = _o_.award;
/* 559 */       this.num = _o_.num;
/* 560 */       this.last_time = _o_.last_time;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.award = _o_.award;
/* 566 */       this.num = _o_.num;
/* 567 */       this.last_time = _o_.last_time;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.award);
/* 574 */       _os_.marshal(this.num);
/* 575 */       _os_.marshal(this.last_time);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.award = _os_.unmarshal_int();
/* 583 */       this.num = _os_.unmarshal_int();
/* 584 */       this.last_time = _os_.unmarshal_long();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.award);
/* 593 */       _size_ += CodedOutputStream.computeInt32Size(2, this.num);
/* 594 */       _size_ += CodedOutputStream.computeInt64Size(3, this.last_time);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.award);
/* 604 */         _output_.writeInt32(2, this.num);
/* 605 */         _output_.writeInt64(3, this.last_time);
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
/* 632 */             this.award = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.num = _input_.readInt32();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.last_time = _input_.readInt64();
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
/*     */     public xbean.VoteAwardInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoteAwardInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.VoteAwardInfo toBean()
/*     */     {
/* 681 */       return new VoteAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.VoteAwardInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.VoteAwardInfo toBeanIf()
/*     */     {
/* 692 */       return new VoteAwardInfo(this, null, null);
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
/*     */     public int getAward()
/*     */     {
/* 729 */       return this.award;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNum()
/*     */     {
/* 736 */       return this.num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getLast_time()
/*     */     {
/* 743 */       return this.last_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward(int _v_)
/*     */     {
/* 750 */       this.award = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNum(int _v_)
/*     */     {
/* 757 */       this.num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_time(long _v_)
/*     */     {
/* 764 */       this.last_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.award != _o_.award) return false;
/* 773 */       if (this.num != _o_.num) return false;
/* 774 */       if (this.last_time != _o_.last_time) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.award;
/* 783 */       _h_ += this.num;
/* 784 */       _h_ = (int)(_h_ + this.last_time);
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.award);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.num);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.last_time);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\VoteAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */