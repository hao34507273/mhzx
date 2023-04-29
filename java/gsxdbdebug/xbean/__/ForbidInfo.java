/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import com.goldhuman.Common.Octets;
/*     */ import java.io.IOException;
/*     */ import ppbio.ByteString;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class ForbidInfo extends XBean implements xbean.ForbidInfo
/*     */ {
/*     */   private long expiretime;
/*     */   private long starttime;
/*     */   private String reason;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.expiretime = 0L;
/*  23 */     this.starttime = 0L;
/*  24 */     this.reason = "";
/*     */   }
/*     */   
/*     */   ForbidInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.reason = "";
/*     */   }
/*     */   
/*     */   public ForbidInfo()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ForbidInfo(ForbidInfo _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ForbidInfo(xbean.ForbidInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof ForbidInfo)) { assign((ForbidInfo)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ForbidInfo _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.expiretime = _o_.expiretime;
/*  56 */     this.starttime = _o_.starttime;
/*  57 */     this.reason = _o_.reason;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  62 */     this.expiretime = _o_.expiretime;
/*  63 */     this.starttime = _o_.starttime;
/*  64 */     this.reason = _o_.reason;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  70 */     _xdb_verify_unsafe_();
/*  71 */     _os_.marshal(this.expiretime);
/*  72 */     _os_.marshal(this.starttime);
/*  73 */     _os_.marshal(this.reason, "UTF-16LE");
/*  74 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  80 */     _xdb_verify_unsafe_();
/*  81 */     this.expiretime = _os_.unmarshal_long();
/*  82 */     this.starttime = _os_.unmarshal_long();
/*  83 */     this.reason = _os_.unmarshal_String("UTF-16LE");
/*  84 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  90 */     _xdb_verify_unsafe_();
/*  91 */     int _size_ = 0;
/*  92 */     _size_ += CodedOutputStream.computeInt64Size(1, this.expiretime);
/*  93 */     _size_ += CodedOutputStream.computeInt64Size(2, this.starttime);
/*     */     try
/*     */     {
/*  96 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.reason, "UTF-16LE"));
/*     */     }
/*     */     catch (java.io.UnsupportedEncodingException e)
/*     */     {
/* 100 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*     */     }
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt64(1, this.expiretime);
/* 112 */       _output_.writeInt64(2, this.starttime);
/* 113 */       _output_.writeBytes(3, ByteString.copyFrom(this.reason, "UTF-16LE"));
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 117 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 119 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 125 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 128 */       boolean done = false;
/* 129 */       while (!done)
/*     */       {
/* 131 */         int tag = _input_.readTag();
/* 132 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 136 */           done = true;
/* 137 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 141 */           this.expiretime = _input_.readInt64();
/* 142 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 146 */           this.starttime = _input_.readInt64();
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 26: 
/* 151 */           this.reason = _input_.readBytes().toString("UTF-16LE");
/* 152 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 156 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 158 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 167 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 171 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 173 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ForbidInfo copy()
/*     */   {
/* 179 */     _xdb_verify_unsafe_();
/* 180 */     return new ForbidInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ForbidInfo toData()
/*     */   {
/* 186 */     _xdb_verify_unsafe_();
/* 187 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ForbidInfo toBean()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new ForbidInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ForbidInfo toDataIf()
/*     */   {
/* 199 */     _xdb_verify_unsafe_();
/* 200 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ForbidInfo toBeanIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getExpiretime()
/*     */   {
/* 220 */     _xdb_verify_unsafe_();
/* 221 */     return this.expiretime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getStarttime()
/*     */   {
/* 228 */     _xdb_verify_unsafe_();
/* 229 */     return this.starttime;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public String getReason()
/*     */   {
/* 236 */     _xdb_verify_unsafe_();
/* 237 */     return this.reason;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public Octets getReasonOctets()
/*     */   {
/* 244 */     _xdb_verify_unsafe_();
/* 245 */     return Octets.wrap(getReason(), "UTF-16LE");
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExpiretime(long _v_)
/*     */   {
/* 252 */     _xdb_verify_unsafe_();
/* 253 */     xdb.Logs.logIf(new LogKey(this, "expiretime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 257 */         new xdb.logs.LogLong(this, ForbidInfo.this.expiretime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 261 */             ForbidInfo.this.expiretime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 265 */     });
/* 266 */     this.expiretime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setStarttime(long _v_)
/*     */   {
/* 273 */     _xdb_verify_unsafe_();
/* 274 */     xdb.Logs.logIf(new LogKey(this, "starttime")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 278 */         new xdb.logs.LogLong(this, ForbidInfo.this.starttime)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 282 */             ForbidInfo.this.starttime = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 286 */     });
/* 287 */     this.starttime = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReason(String _v_)
/*     */   {
/* 294 */     _xdb_verify_unsafe_();
/* 295 */     if (null == _v_)
/* 296 */       throw new NullPointerException();
/* 297 */     xdb.Logs.logIf(new LogKey(this, "reason")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 301 */         new xdb.logs.LogString(this, ForbidInfo.this.reason)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 305 */             ForbidInfo.this.reason = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 309 */     });
/* 310 */     this.reason = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setReasonOctets(Octets _v_)
/*     */   {
/* 317 */     _xdb_verify_unsafe_();
/* 318 */     setReason(_v_.getString("UTF-16LE"));
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 324 */     _xdb_verify_unsafe_();
/* 325 */     ForbidInfo _o_ = null;
/* 326 */     if ((_o1_ instanceof ForbidInfo)) { _o_ = (ForbidInfo)_o1_;
/* 327 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 328 */       return false;
/* 329 */     if (this.expiretime != _o_.expiretime) return false;
/* 330 */     if (this.starttime != _o_.starttime) return false;
/* 331 */     if (!this.reason.equals(_o_.reason)) return false;
/* 332 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 338 */     _xdb_verify_unsafe_();
/* 339 */     int _h_ = 0;
/* 340 */     _h_ = (int)(_h_ + this.expiretime);
/* 341 */     _h_ = (int)(_h_ + this.starttime);
/* 342 */     _h_ += this.reason.hashCode();
/* 343 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 349 */     _xdb_verify_unsafe_();
/* 350 */     StringBuilder _sb_ = new StringBuilder();
/* 351 */     _sb_.append("(");
/* 352 */     _sb_.append(this.expiretime);
/* 353 */     _sb_.append(",");
/* 354 */     _sb_.append(this.starttime);
/* 355 */     _sb_.append(",");
/* 356 */     _sb_.append("'").append(this.reason).append("'");
/* 357 */     _sb_.append(")");
/* 358 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 364 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 365 */     lb.add(new ListenableChanged().setVarName("expiretime"));
/* 366 */     lb.add(new ListenableChanged().setVarName("starttime"));
/* 367 */     lb.add(new ListenableChanged().setVarName("reason"));
/* 368 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ForbidInfo {
/*     */     private Const() {}
/*     */     
/*     */     ForbidInfo nThis() {
/* 375 */       return ForbidInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForbidInfo copy()
/*     */     {
/* 387 */       return ForbidInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForbidInfo toData()
/*     */     {
/* 393 */       return ForbidInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ForbidInfo toBean()
/*     */     {
/* 398 */       return ForbidInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForbidInfo toDataIf()
/*     */     {
/* 404 */       return ForbidInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ForbidInfo toBeanIf()
/*     */     {
/* 409 */       return ForbidInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExpiretime()
/*     */     {
/* 416 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 417 */       return ForbidInfo.this.expiretime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 424 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 425 */       return ForbidInfo.this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getReason()
/*     */     {
/* 432 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 433 */       return ForbidInfo.this.reason;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getReasonOctets()
/*     */     {
/* 440 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 441 */       return ForbidInfo.this.getReasonOctets();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpiretime(long _v_)
/*     */     {
/* 448 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 449 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 456 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 457 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReason(String _v_)
/*     */     {
/* 464 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 465 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReasonOctets(Octets _v_)
/*     */     {
/* 472 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 473 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 479 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 480 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 486 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 487 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 493 */       return ForbidInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 499 */       return ForbidInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 505 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 506 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 512 */       return ForbidInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 518 */       return ForbidInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 524 */       ForbidInfo.this._xdb_verify_unsafe_();
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 531 */       return ForbidInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 537 */       return ForbidInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 543 */       return ForbidInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 549 */       return ForbidInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 555 */       return ForbidInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 561 */       return ForbidInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 567 */       return ForbidInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ForbidInfo
/*     */   {
/*     */     private long expiretime;
/*     */     
/*     */     private long starttime;
/*     */     
/*     */     private String reason;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 583 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 588 */       this.reason = "";
/*     */     }
/*     */     
/*     */     Data(xbean.ForbidInfo _o1_)
/*     */     {
/* 593 */       if ((_o1_ instanceof ForbidInfo)) { assign((ForbidInfo)_o1_);
/* 594 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 595 */       } else if ((_o1_ instanceof ForbidInfo.Const)) assign(((ForbidInfo.Const)_o1_).nThis()); else {
/* 596 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ForbidInfo _o_) {
/* 601 */       this.expiretime = _o_.expiretime;
/* 602 */       this.starttime = _o_.starttime;
/* 603 */       this.reason = _o_.reason;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 608 */       this.expiretime = _o_.expiretime;
/* 609 */       this.starttime = _o_.starttime;
/* 610 */       this.reason = _o_.reason;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 616 */       _os_.marshal(this.expiretime);
/* 617 */       _os_.marshal(this.starttime);
/* 618 */       _os_.marshal(this.reason, "UTF-16LE");
/* 619 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 625 */       this.expiretime = _os_.unmarshal_long();
/* 626 */       this.starttime = _os_.unmarshal_long();
/* 627 */       this.reason = _os_.unmarshal_String("UTF-16LE");
/* 628 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 634 */       int _size_ = 0;
/* 635 */       _size_ += CodedOutputStream.computeInt64Size(1, this.expiretime);
/* 636 */       _size_ += CodedOutputStream.computeInt64Size(2, this.starttime);
/*     */       try
/*     */       {
/* 639 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.reason, "UTF-16LE"));
/*     */       }
/*     */       catch (java.io.UnsupportedEncodingException e)
/*     */       {
/* 643 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*     */       }
/* 645 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 653 */         _output_.writeInt64(1, this.expiretime);
/* 654 */         _output_.writeInt64(2, this.starttime);
/* 655 */         _output_.writeBytes(3, ByteString.copyFrom(this.reason, "UTF-16LE"));
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 659 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 661 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 669 */         boolean done = false;
/* 670 */         while (!done)
/*     */         {
/* 672 */           int tag = _input_.readTag();
/* 673 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 677 */             done = true;
/* 678 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 682 */             this.expiretime = _input_.readInt64();
/* 683 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 687 */             this.starttime = _input_.readInt64();
/* 688 */             break;
/*     */           
/*     */ 
/*     */           case 26: 
/* 692 */             this.reason = _input_.readBytes().toString("UTF-16LE");
/* 693 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 697 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 699 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 708 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 712 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 714 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForbidInfo copy()
/*     */     {
/* 720 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForbidInfo toData()
/*     */     {
/* 726 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ForbidInfo toBean()
/*     */     {
/* 731 */       return new ForbidInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ForbidInfo toDataIf()
/*     */     {
/* 737 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ForbidInfo toBeanIf()
/*     */     {
/* 742 */       return new ForbidInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 748 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 752 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 756 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 760 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 764 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 768 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 772 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExpiretime()
/*     */     {
/* 779 */       return this.expiretime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getStarttime()
/*     */     {
/* 786 */       return this.starttime;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public String getReason()
/*     */     {
/* 793 */       return this.reason;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public Octets getReasonOctets()
/*     */     {
/* 800 */       return Octets.wrap(getReason(), "UTF-16LE");
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpiretime(long _v_)
/*     */     {
/* 807 */       this.expiretime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setStarttime(long _v_)
/*     */     {
/* 814 */       this.starttime = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReason(String _v_)
/*     */     {
/* 821 */       if (null == _v_)
/* 822 */         throw new NullPointerException();
/* 823 */       this.reason = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setReasonOctets(Octets _v_)
/*     */     {
/* 830 */       setReason(_v_.getString("UTF-16LE"));
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 836 */       if (!(_o1_ instanceof Data)) return false;
/* 837 */       Data _o_ = (Data)_o1_;
/* 838 */       if (this.expiretime != _o_.expiretime) return false;
/* 839 */       if (this.starttime != _o_.starttime) return false;
/* 840 */       if (!this.reason.equals(_o_.reason)) return false;
/* 841 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 847 */       int _h_ = 0;
/* 848 */       _h_ = (int)(_h_ + this.expiretime);
/* 849 */       _h_ = (int)(_h_ + this.starttime);
/* 850 */       _h_ += this.reason.hashCode();
/* 851 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 857 */       StringBuilder _sb_ = new StringBuilder();
/* 858 */       _sb_.append("(");
/* 859 */       _sb_.append(this.expiretime);
/* 860 */       _sb_.append(",");
/* 861 */       _sb_.append(this.starttime);
/* 862 */       _sb_.append(",");
/* 863 */       _sb_.append("'").append(this.reason).append("'");
/* 864 */       _sb_.append(")");
/* 865 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ForbidInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */