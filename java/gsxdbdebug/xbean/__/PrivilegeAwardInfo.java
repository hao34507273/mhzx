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
/*     */ 
/*     */ public final class PrivilegeAwardInfo extends XBean implements xbean.PrivilegeAwardInfo
/*     */ {
/*     */   private long award_timestamp;
/*     */   private int award_num;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.award_timestamp = 0L;
/*  21 */     this.award_num = 0;
/*     */   }
/*     */   
/*     */   PrivilegeAwardInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public PrivilegeAwardInfo()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public PrivilegeAwardInfo(PrivilegeAwardInfo _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   PrivilegeAwardInfo(xbean.PrivilegeAwardInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof PrivilegeAwardInfo)) { assign((PrivilegeAwardInfo)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(PrivilegeAwardInfo _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.award_timestamp = _o_.award_timestamp;
/*  52 */     this.award_num = _o_.award_num;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.award_timestamp = _o_.award_timestamp;
/*  58 */     this.award_num = _o_.award_num;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.award_timestamp);
/*  66 */     _os_.marshal(this.award_num);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.award_timestamp = _os_.unmarshal_long();
/*  75 */     this.award_num = _os_.unmarshal_int();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeInt64Size(1, this.award_timestamp);
/*  85 */     _size_ += CodedOutputStream.computeInt32Size(2, this.award_num);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeInt64(1, this.award_timestamp);
/*  96 */       _output_.writeInt32(2, this.award_num);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 100 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 102 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       boolean done = false;
/* 112 */       while (!done)
/*     */       {
/* 114 */         int tag = _input_.readTag();
/* 115 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 119 */           done = true;
/* 120 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 124 */           this.award_timestamp = _input_.readInt64();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 129 */           this.award_num = _input_.readInt32();
/* 130 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 134 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 136 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 145 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 149 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 151 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PrivilegeAwardInfo copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new PrivilegeAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PrivilegeAwardInfo toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PrivilegeAwardInfo toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new PrivilegeAwardInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.PrivilegeAwardInfo toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.PrivilegeAwardInfo toBeanIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 190 */     _xdb_verify_unsafe_();
/* 191 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getAward_timestamp()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.award_timestamp;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAward_num()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.award_num;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAward_timestamp(long _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "award_timestamp")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new xdb.logs.LogLong(this, PrivilegeAwardInfo.this.award_timestamp)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             PrivilegeAwardInfo.this.award_timestamp = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.award_timestamp = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAward_num(int _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "award_num")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new xdb.logs.LogInt(this, PrivilegeAwardInfo.this.award_num)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             PrivilegeAwardInfo.this.award_num = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.award_num = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     PrivilegeAwardInfo _o_ = null;
/* 257 */     if ((_o1_ instanceof PrivilegeAwardInfo)) { _o_ = (PrivilegeAwardInfo)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.award_timestamp != _o_.award_timestamp) return false;
/* 261 */     if (this.award_num != _o_.award_num) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ = (int)(_h_ + this.award_timestamp);
/* 271 */     _h_ += this.award_num;
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.award_timestamp);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.award_num);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     ListenableBean lb = new ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("award_timestamp"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("award_num"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.PrivilegeAwardInfo {
/*     */     private Const() {}
/*     */     
/*     */     PrivilegeAwardInfo nThis() {
/* 301 */       return PrivilegeAwardInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PrivilegeAwardInfo copy()
/*     */     {
/* 313 */       return PrivilegeAwardInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PrivilegeAwardInfo toData()
/*     */     {
/* 319 */       return PrivilegeAwardInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.PrivilegeAwardInfo toBean()
/*     */     {
/* 324 */       return PrivilegeAwardInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PrivilegeAwardInfo toDataIf()
/*     */     {
/* 330 */       return PrivilegeAwardInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.PrivilegeAwardInfo toBeanIf()
/*     */     {
/* 335 */       return PrivilegeAwardInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAward_timestamp()
/*     */     {
/* 342 */       PrivilegeAwardInfo.this._xdb_verify_unsafe_();
/* 343 */       return PrivilegeAwardInfo.this.award_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAward_num()
/*     */     {
/* 350 */       PrivilegeAwardInfo.this._xdb_verify_unsafe_();
/* 351 */       return PrivilegeAwardInfo.this.award_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_timestamp(long _v_)
/*     */     {
/* 358 */       PrivilegeAwardInfo.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_num(int _v_)
/*     */     {
/* 366 */       PrivilegeAwardInfo.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       PrivilegeAwardInfo.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       PrivilegeAwardInfo.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return PrivilegeAwardInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return PrivilegeAwardInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       PrivilegeAwardInfo.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return PrivilegeAwardInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return PrivilegeAwardInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       PrivilegeAwardInfo.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return PrivilegeAwardInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return PrivilegeAwardInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return PrivilegeAwardInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return PrivilegeAwardInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return PrivilegeAwardInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return PrivilegeAwardInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return PrivilegeAwardInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.PrivilegeAwardInfo
/*     */   {
/*     */     private long award_timestamp;
/*     */     
/*     */     private int award_num;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 475 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.PrivilegeAwardInfo _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof PrivilegeAwardInfo)) { assign((PrivilegeAwardInfo)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof PrivilegeAwardInfo.Const)) assign(((PrivilegeAwardInfo.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(PrivilegeAwardInfo _o_) {
/* 492 */       this.award_timestamp = _o_.award_timestamp;
/* 493 */       this.award_num = _o_.award_num;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.award_timestamp = _o_.award_timestamp;
/* 499 */       this.award_num = _o_.award_num;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.award_timestamp);
/* 506 */       _os_.marshal(this.award_num);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.award_timestamp = _os_.unmarshal_long();
/* 514 */       this.award_num = _os_.unmarshal_int();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeInt64Size(1, this.award_timestamp);
/* 523 */       _size_ += CodedOutputStream.computeInt32Size(2, this.award_num);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeInt64(1, this.award_timestamp);
/* 533 */         _output_.writeInt32(2, this.award_num);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 537 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 539 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 547 */         boolean done = false;
/* 548 */         while (!done)
/*     */         {
/* 550 */           int tag = _input_.readTag();
/* 551 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 555 */             done = true;
/* 556 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 560 */             this.award_timestamp = _input_.readInt64();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 565 */             this.award_num = _input_.readInt32();
/* 566 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 570 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 572 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 581 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 585 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 587 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PrivilegeAwardInfo copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PrivilegeAwardInfo toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.PrivilegeAwardInfo toBean()
/*     */     {
/* 604 */       return new PrivilegeAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.PrivilegeAwardInfo toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.PrivilegeAwardInfo toBeanIf()
/*     */     {
/* 615 */       return new PrivilegeAwardInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 621 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 625 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 629 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 633 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 637 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 641 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 645 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAward_timestamp()
/*     */     {
/* 652 */       return this.award_timestamp;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAward_num()
/*     */     {
/* 659 */       return this.award_num;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_timestamp(long _v_)
/*     */     {
/* 666 */       this.award_timestamp = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAward_num(int _v_)
/*     */     {
/* 673 */       this.award_num = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.award_timestamp != _o_.award_timestamp) return false;
/* 682 */       if (this.award_num != _o_.award_num) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ = (int)(_h_ + this.award_timestamp);
/* 691 */       _h_ += this.award_num;
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.award_timestamp);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.award_num);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\PrivilegeAwardInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */