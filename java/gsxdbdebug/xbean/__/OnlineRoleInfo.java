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
/*     */ public final class OnlineRoleInfo extends XBean implements xbean.OnlineRoleInfo
/*     */ {
/*     */   private int onlinestatus;
/*     */   private long offlineprotectsessionid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.onlinestatus = 0;
/*  21 */     this.offlineprotectsessionid = 0L;
/*     */   }
/*     */   
/*     */   OnlineRoleInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public OnlineRoleInfo()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public OnlineRoleInfo(OnlineRoleInfo _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   OnlineRoleInfo(xbean.OnlineRoleInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof OnlineRoleInfo)) { assign((OnlineRoleInfo)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(OnlineRoleInfo _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.onlinestatus = _o_.onlinestatus;
/*  52 */     this.offlineprotectsessionid = _o_.offlineprotectsessionid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.onlinestatus = _o_.onlinestatus;
/*  58 */     this.offlineprotectsessionid = _o_.offlineprotectsessionid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.onlinestatus);
/*  66 */     _os_.marshal(this.offlineprotectsessionid);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.onlinestatus = _os_.unmarshal_int();
/*  75 */     this.offlineprotectsessionid = _os_.unmarshal_long();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeInt32Size(1, this.onlinestatus);
/*  85 */     _size_ += CodedOutputStream.computeInt64Size(3, this.offlineprotectsessionid);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeInt32(1, this.onlinestatus);
/*  96 */       _output_.writeInt64(3, this.offlineprotectsessionid);
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
/* 124 */           this.onlinestatus = _input_.readInt32();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 129 */           this.offlineprotectsessionid = _input_.readInt64();
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
/*     */   public xbean.OnlineRoleInfo copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new OnlineRoleInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.OnlineRoleInfo toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.OnlineRoleInfo toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new OnlineRoleInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.OnlineRoleInfo toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.OnlineRoleInfo toBeanIf()
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
/*     */   public int getOnlinestatus()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.onlinestatus;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getOfflineprotectsessionid()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.offlineprotectsessionid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOnlinestatus(int _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "onlinestatus")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new xdb.logs.LogInt(this, OnlineRoleInfo.this.onlinestatus)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             OnlineRoleInfo.this.onlinestatus = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.onlinestatus = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setOfflineprotectsessionid(long _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "offlineprotectsessionid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new xdb.logs.LogLong(this, OnlineRoleInfo.this.offlineprotectsessionid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             OnlineRoleInfo.this.offlineprotectsessionid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.offlineprotectsessionid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     OnlineRoleInfo _o_ = null;
/* 257 */     if ((_o1_ instanceof OnlineRoleInfo)) { _o_ = (OnlineRoleInfo)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.onlinestatus != _o_.onlinestatus) return false;
/* 261 */     if (this.offlineprotectsessionid != _o_.offlineprotectsessionid) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ += this.onlinestatus;
/* 271 */     _h_ = (int)(_h_ + this.offlineprotectsessionid);
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.onlinestatus);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.offlineprotectsessionid);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     ListenableBean lb = new ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("onlinestatus"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("offlineprotectsessionid"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.OnlineRoleInfo {
/*     */     private Const() {}
/*     */     
/*     */     OnlineRoleInfo nThis() {
/* 301 */       return OnlineRoleInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OnlineRoleInfo copy()
/*     */     {
/* 313 */       return OnlineRoleInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OnlineRoleInfo toData()
/*     */     {
/* 319 */       return OnlineRoleInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.OnlineRoleInfo toBean()
/*     */     {
/* 324 */       return OnlineRoleInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OnlineRoleInfo toDataIf()
/*     */     {
/* 330 */       return OnlineRoleInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.OnlineRoleInfo toBeanIf()
/*     */     {
/* 335 */       return OnlineRoleInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getOnlinestatus()
/*     */     {
/* 342 */       OnlineRoleInfo.this._xdb_verify_unsafe_();
/* 343 */       return OnlineRoleInfo.this.onlinestatus;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getOfflineprotectsessionid()
/*     */     {
/* 350 */       OnlineRoleInfo.this._xdb_verify_unsafe_();
/* 351 */       return OnlineRoleInfo.this.offlineprotectsessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOnlinestatus(int _v_)
/*     */     {
/* 358 */       OnlineRoleInfo.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOfflineprotectsessionid(long _v_)
/*     */     {
/* 366 */       OnlineRoleInfo.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       OnlineRoleInfo.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       OnlineRoleInfo.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return OnlineRoleInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return OnlineRoleInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       OnlineRoleInfo.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return OnlineRoleInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return OnlineRoleInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       OnlineRoleInfo.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return OnlineRoleInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return OnlineRoleInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return OnlineRoleInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return OnlineRoleInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return OnlineRoleInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return OnlineRoleInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return OnlineRoleInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.OnlineRoleInfo
/*     */   {
/*     */     private int onlinestatus;
/*     */     
/*     */     private long offlineprotectsessionid;
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
/*     */     Data(xbean.OnlineRoleInfo _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof OnlineRoleInfo)) { assign((OnlineRoleInfo)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof OnlineRoleInfo.Const)) assign(((OnlineRoleInfo.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(OnlineRoleInfo _o_) {
/* 492 */       this.onlinestatus = _o_.onlinestatus;
/* 493 */       this.offlineprotectsessionid = _o_.offlineprotectsessionid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.onlinestatus = _o_.onlinestatus;
/* 499 */       this.offlineprotectsessionid = _o_.offlineprotectsessionid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.onlinestatus);
/* 506 */       _os_.marshal(this.offlineprotectsessionid);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.onlinestatus = _os_.unmarshal_int();
/* 514 */       this.offlineprotectsessionid = _os_.unmarshal_long();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeInt32Size(1, this.onlinestatus);
/* 523 */       _size_ += CodedOutputStream.computeInt64Size(3, this.offlineprotectsessionid);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeInt32(1, this.onlinestatus);
/* 533 */         _output_.writeInt64(3, this.offlineprotectsessionid);
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
/* 560 */             this.onlinestatus = _input_.readInt32();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 565 */             this.offlineprotectsessionid = _input_.readInt64();
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
/*     */     public xbean.OnlineRoleInfo copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OnlineRoleInfo toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.OnlineRoleInfo toBean()
/*     */     {
/* 604 */       return new OnlineRoleInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.OnlineRoleInfo toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.OnlineRoleInfo toBeanIf()
/*     */     {
/* 615 */       return new OnlineRoleInfo(this, null, null);
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
/*     */     public int getOnlinestatus()
/*     */     {
/* 652 */       return this.onlinestatus;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getOfflineprotectsessionid()
/*     */     {
/* 659 */       return this.offlineprotectsessionid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOnlinestatus(int _v_)
/*     */     {
/* 666 */       this.onlinestatus = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setOfflineprotectsessionid(long _v_)
/*     */     {
/* 673 */       this.offlineprotectsessionid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.onlinestatus != _o_.onlinestatus) return false;
/* 682 */       if (this.offlineprotectsessionid != _o_.offlineprotectsessionid) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ += this.onlinestatus;
/* 691 */       _h_ = (int)(_h_ + this.offlineprotectsessionid);
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.onlinestatus);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.offlineprotectsessionid);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\OnlineRoleInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */