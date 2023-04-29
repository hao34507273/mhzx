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
/*     */ public final class RebateInfo extends XBean implements xbean.RebateInfo
/*     */ {
/*     */   private int total_num;
/*     */   private long receive_time;
/*     */   private int receive_num;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.total_num = 0;
/*  23 */     this.receive_time = 0L;
/*  24 */     this.receive_num = 0;
/*     */   }
/*     */   
/*     */   RebateInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public RebateInfo()
/*     */   {
/*  34 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public RebateInfo(RebateInfo _o_)
/*     */   {
/*  39 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   RebateInfo(xbean.RebateInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  44 */     super(_xp_, _vn_);
/*  45 */     if ((_o1_ instanceof RebateInfo)) { assign((RebateInfo)_o1_);
/*  46 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  47 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  48 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(RebateInfo _o_) {
/*  53 */     _o_._xdb_verify_unsafe_();
/*  54 */     this.total_num = _o_.total_num;
/*  55 */     this.receive_time = _o_.receive_time;
/*  56 */     this.receive_num = _o_.receive_num;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  61 */     this.total_num = _o_.total_num;
/*  62 */     this.receive_time = _o_.receive_time;
/*  63 */     this.receive_num = _o_.receive_num;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  69 */     _xdb_verify_unsafe_();
/*  70 */     _os_.marshal(this.total_num);
/*  71 */     _os_.marshal(this.receive_time);
/*  72 */     _os_.marshal(this.receive_num);
/*  73 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  79 */     _xdb_verify_unsafe_();
/*  80 */     this.total_num = _os_.unmarshal_int();
/*  81 */     this.receive_time = _os_.unmarshal_long();
/*  82 */     this.receive_num = _os_.unmarshal_int();
/*  83 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  89 */     _xdb_verify_unsafe_();
/*  90 */     int _size_ = 0;
/*  91 */     _size_ += CodedOutputStream.computeInt32Size(1, this.total_num);
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(2, this.receive_time);
/*  93 */     _size_ += CodedOutputStream.computeInt32Size(3, this.receive_num);
/*  94 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       _output_.writeInt32(1, this.total_num);
/* 104 */       _output_.writeInt64(2, this.receive_time);
/* 105 */       _output_.writeInt32(3, this.receive_num);
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
/* 133 */           this.total_num = _input_.readInt32();
/* 134 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 138 */           this.receive_time = _input_.readInt64();
/* 139 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 143 */           this.receive_num = _input_.readInt32();
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
/*     */   public xbean.RebateInfo copy()
/*     */   {
/* 171 */     _xdb_verify_unsafe_();
/* 172 */     return new RebateInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RebateInfo toData()
/*     */   {
/* 178 */     _xdb_verify_unsafe_();
/* 179 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RebateInfo toBean()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return new RebateInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.RebateInfo toDataIf()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.RebateInfo toBeanIf()
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
/*     */   public int getTotal_num()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return this.total_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getReceive_time()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.receive_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getReceive_num()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.receive_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTotal_num(int _v_)
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     xdb.Logs.logIf(new LogKey(this, "total_num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 241 */         new xdb.logs.LogInt(this, RebateInfo.this.total_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 245 */             RebateInfo.this.total_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 249 */     });
/* 250 */     this.total_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReceive_time(long _v_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     xdb.Logs.logIf(new LogKey(this, "receive_time")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 262 */         new xdb.logs.LogLong(this, RebateInfo.this.receive_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 266 */             RebateInfo.this.receive_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 270 */     });
/* 271 */     this.receive_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReceive_num(int _v_)
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     xdb.Logs.logIf(new LogKey(this, "receive_num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 283 */         new xdb.logs.LogInt(this, RebateInfo.this.receive_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 287 */             RebateInfo.this.receive_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 291 */     });
/* 292 */     this.receive_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 298 */     _xdb_verify_unsafe_();
/* 299 */     RebateInfo _o_ = null;
/* 300 */     if ((_o1_ instanceof RebateInfo)) { _o_ = (RebateInfo)_o1_;
/* 301 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 302 */       return false;
/* 303 */     if (this.total_num != _o_.total_num) return false;
/* 304 */     if (this.receive_time != _o_.receive_time) return false;
/* 305 */     if (this.receive_num != _o_.receive_num) return false;
/* 306 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 312 */     _xdb_verify_unsafe_();
/* 313 */     int _h_ = 0;
/* 314 */     _h_ += this.total_num;
/* 315 */     _h_ = (int)(_h_ + this.receive_time);
/* 316 */     _h_ += this.receive_num;
/* 317 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 323 */     _xdb_verify_unsafe_();
/* 324 */     StringBuilder _sb_ = new StringBuilder();
/* 325 */     _sb_.append("(");
/* 326 */     _sb_.append(this.total_num);
/* 327 */     _sb_.append(",");
/* 328 */     _sb_.append(this.receive_time);
/* 329 */     _sb_.append(",");
/* 330 */     _sb_.append(this.receive_num);
/* 331 */     _sb_.append(")");
/* 332 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 338 */     ListenableBean lb = new ListenableBean();
/* 339 */     lb.add(new ListenableChanged().setVarName("total_num"));
/* 340 */     lb.add(new ListenableChanged().setVarName("receive_time"));
/* 341 */     lb.add(new ListenableChanged().setVarName("receive_num"));
/* 342 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.RebateInfo {
/*     */     private Const() {}
/*     */     
/*     */     RebateInfo nThis() {
/* 349 */       return RebateInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RebateInfo copy()
/*     */     {
/* 361 */       return RebateInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RebateInfo toData()
/*     */     {
/* 367 */       return RebateInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.RebateInfo toBean()
/*     */     {
/* 372 */       return RebateInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RebateInfo toDataIf()
/*     */     {
/* 378 */       return RebateInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.RebateInfo toBeanIf()
/*     */     {
/* 383 */       return RebateInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTotal_num()
/*     */     {
/* 390 */       RebateInfo.this._xdb_verify_unsafe_();
/* 391 */       return RebateInfo.this.total_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getReceive_time()
/*     */     {
/* 398 */       RebateInfo.this._xdb_verify_unsafe_();
/* 399 */       return RebateInfo.this.receive_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getReceive_num()
/*     */     {
/* 406 */       RebateInfo.this._xdb_verify_unsafe_();
/* 407 */       return RebateInfo.this.receive_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotal_num(int _v_)
/*     */     {
/* 414 */       RebateInfo.this._xdb_verify_unsafe_();
/* 415 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReceive_time(long _v_)
/*     */     {
/* 422 */       RebateInfo.this._xdb_verify_unsafe_();
/* 423 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReceive_num(int _v_)
/*     */     {
/* 430 */       RebateInfo.this._xdb_verify_unsafe_();
/* 431 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 437 */       RebateInfo.this._xdb_verify_unsafe_();
/* 438 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 444 */       RebateInfo.this._xdb_verify_unsafe_();
/* 445 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 451 */       return RebateInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 457 */       return RebateInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 463 */       RebateInfo.this._xdb_verify_unsafe_();
/* 464 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 470 */       return RebateInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 476 */       return RebateInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 482 */       RebateInfo.this._xdb_verify_unsafe_();
/* 483 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 489 */       return RebateInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 495 */       return RebateInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 501 */       return RebateInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 507 */       return RebateInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 513 */       return RebateInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 519 */       return RebateInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 525 */       return RebateInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.RebateInfo
/*     */   {
/*     */     private int total_num;
/*     */     
/*     */     private long receive_time;
/*     */     
/*     */     private int receive_num;
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
/*     */     Data(xbean.RebateInfo _o1_)
/*     */     {
/* 550 */       if ((_o1_ instanceof RebateInfo)) { assign((RebateInfo)_o1_);
/* 551 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 552 */       } else if ((_o1_ instanceof RebateInfo.Const)) assign(((RebateInfo.Const)_o1_).nThis()); else {
/* 553 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(RebateInfo _o_) {
/* 558 */       this.total_num = _o_.total_num;
/* 559 */       this.receive_time = _o_.receive_time;
/* 560 */       this.receive_num = _o_.receive_num;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 565 */       this.total_num = _o_.total_num;
/* 566 */       this.receive_time = _o_.receive_time;
/* 567 */       this.receive_num = _o_.receive_num;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 573 */       _os_.marshal(this.total_num);
/* 574 */       _os_.marshal(this.receive_time);
/* 575 */       _os_.marshal(this.receive_num);
/* 576 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 582 */       this.total_num = _os_.unmarshal_int();
/* 583 */       this.receive_time = _os_.unmarshal_long();
/* 584 */       this.receive_num = _os_.unmarshal_int();
/* 585 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 591 */       int _size_ = 0;
/* 592 */       _size_ += CodedOutputStream.computeInt32Size(1, this.total_num);
/* 593 */       _size_ += CodedOutputStream.computeInt64Size(2, this.receive_time);
/* 594 */       _size_ += CodedOutputStream.computeInt32Size(3, this.receive_num);
/* 595 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 603 */         _output_.writeInt32(1, this.total_num);
/* 604 */         _output_.writeInt64(2, this.receive_time);
/* 605 */         _output_.writeInt32(3, this.receive_num);
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
/* 632 */             this.total_num = _input_.readInt32();
/* 633 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 637 */             this.receive_time = _input_.readInt64();
/* 638 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 642 */             this.receive_num = _input_.readInt32();
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
/*     */     public xbean.RebateInfo copy()
/*     */     {
/* 670 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RebateInfo toData()
/*     */     {
/* 676 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.RebateInfo toBean()
/*     */     {
/* 681 */       return new RebateInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.RebateInfo toDataIf()
/*     */     {
/* 687 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.RebateInfo toBeanIf()
/*     */     {
/* 692 */       return new RebateInfo(this, null, null);
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
/*     */     public int getTotal_num()
/*     */     {
/* 729 */       return this.total_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getReceive_time()
/*     */     {
/* 736 */       return this.receive_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getReceive_num()
/*     */     {
/* 743 */       return this.receive_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTotal_num(int _v_)
/*     */     {
/* 750 */       this.total_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReceive_time(long _v_)
/*     */     {
/* 757 */       this.receive_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReceive_num(int _v_)
/*     */     {
/* 764 */       this.receive_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 770 */       if (!(_o1_ instanceof Data)) return false;
/* 771 */       Data _o_ = (Data)_o1_;
/* 772 */       if (this.total_num != _o_.total_num) return false;
/* 773 */       if (this.receive_time != _o_.receive_time) return false;
/* 774 */       if (this.receive_num != _o_.receive_num) return false;
/* 775 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 781 */       int _h_ = 0;
/* 782 */       _h_ += this.total_num;
/* 783 */       _h_ = (int)(_h_ + this.receive_time);
/* 784 */       _h_ += this.receive_num;
/* 785 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 791 */       StringBuilder _sb_ = new StringBuilder();
/* 792 */       _sb_.append("(");
/* 793 */       _sb_.append(this.total_num);
/* 794 */       _sb_.append(",");
/* 795 */       _sb_.append(this.receive_time);
/* 796 */       _sb_.append(",");
/* 797 */       _sb_.append(this.receive_num);
/* 798 */       _sb_.append(")");
/* 799 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\RebateInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */