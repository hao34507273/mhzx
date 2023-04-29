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
/*     */ import xdb.logs.LogLong;
/*     */ 
/*     */ public final class Role2ChangeModelCardSessionInfo extends XBean implements xbean.Role2ChangeModelCardSessionInfo
/*     */ {
/*     */   private long main_session_id;
/*     */   private long expire_notify_session_id;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.main_session_id = 0L;
/*  21 */     this.expire_notify_session_id = 0L;
/*     */   }
/*     */   
/*     */   Role2ChangeModelCardSessionInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public Role2ChangeModelCardSessionInfo()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Role2ChangeModelCardSessionInfo(Role2ChangeModelCardSessionInfo _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Role2ChangeModelCardSessionInfo(xbean.Role2ChangeModelCardSessionInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof Role2ChangeModelCardSessionInfo)) { assign((Role2ChangeModelCardSessionInfo)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Role2ChangeModelCardSessionInfo _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.main_session_id = _o_.main_session_id;
/*  52 */     this.expire_notify_session_id = _o_.expire_notify_session_id;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.main_session_id = _o_.main_session_id;
/*  58 */     this.expire_notify_session_id = _o_.expire_notify_session_id;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.main_session_id);
/*  66 */     _os_.marshal(this.expire_notify_session_id);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.main_session_id = _os_.unmarshal_long();
/*  75 */     this.expire_notify_session_id = _os_.unmarshal_long();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeInt64Size(1, this.main_session_id);
/*  85 */     _size_ += CodedOutputStream.computeInt64Size(2, this.expire_notify_session_id);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeInt64(1, this.main_session_id);
/*  96 */       _output_.writeInt64(2, this.expire_notify_session_id);
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
/* 124 */           this.main_session_id = _input_.readInt64();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 129 */           this.expire_notify_session_id = _input_.readInt64();
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
/*     */   public xbean.Role2ChangeModelCardSessionInfo copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new Role2ChangeModelCardSessionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2ChangeModelCardSessionInfo toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2ChangeModelCardSessionInfo toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new Role2ChangeModelCardSessionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2ChangeModelCardSessionInfo toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2ChangeModelCardSessionInfo toBeanIf()
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
/*     */   public long getMain_session_id()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.main_session_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getExpire_notify_session_id()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.expire_notify_session_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMain_session_id(long _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "main_session_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new LogLong(this, Role2ChangeModelCardSessionInfo.this.main_session_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             Role2ChangeModelCardSessionInfo.this.main_session_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.main_session_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setExpire_notify_session_id(long _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "expire_notify_session_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new LogLong(this, Role2ChangeModelCardSessionInfo.this.expire_notify_session_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             Role2ChangeModelCardSessionInfo.this.expire_notify_session_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.expire_notify_session_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     Role2ChangeModelCardSessionInfo _o_ = null;
/* 257 */     if ((_o1_ instanceof Role2ChangeModelCardSessionInfo)) { _o_ = (Role2ChangeModelCardSessionInfo)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.main_session_id != _o_.main_session_id) return false;
/* 261 */     if (this.expire_notify_session_id != _o_.expire_notify_session_id) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ = (int)(_h_ + this.main_session_id);
/* 271 */     _h_ = (int)(_h_ + this.expire_notify_session_id);
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.main_session_id);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.expire_notify_session_id);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("main_session_id"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("expire_notify_session_id"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Role2ChangeModelCardSessionInfo {
/*     */     private Const() {}
/*     */     
/*     */     Role2ChangeModelCardSessionInfo nThis() {
/* 301 */       return Role2ChangeModelCardSessionInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2ChangeModelCardSessionInfo copy()
/*     */     {
/* 313 */       return Role2ChangeModelCardSessionInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2ChangeModelCardSessionInfo toData()
/*     */     {
/* 319 */       return Role2ChangeModelCardSessionInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Role2ChangeModelCardSessionInfo toBean()
/*     */     {
/* 324 */       return Role2ChangeModelCardSessionInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2ChangeModelCardSessionInfo toDataIf()
/*     */     {
/* 330 */       return Role2ChangeModelCardSessionInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Role2ChangeModelCardSessionInfo toBeanIf()
/*     */     {
/* 335 */       return Role2ChangeModelCardSessionInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getMain_session_id()
/*     */     {
/* 342 */       Role2ChangeModelCardSessionInfo.this._xdb_verify_unsafe_();
/* 343 */       return Role2ChangeModelCardSessionInfo.this.main_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExpire_notify_session_id()
/*     */     {
/* 350 */       Role2ChangeModelCardSessionInfo.this._xdb_verify_unsafe_();
/* 351 */       return Role2ChangeModelCardSessionInfo.this.expire_notify_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMain_session_id(long _v_)
/*     */     {
/* 358 */       Role2ChangeModelCardSessionInfo.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpire_notify_session_id(long _v_)
/*     */     {
/* 366 */       Role2ChangeModelCardSessionInfo.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       Role2ChangeModelCardSessionInfo.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       Role2ChangeModelCardSessionInfo.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return Role2ChangeModelCardSessionInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return Role2ChangeModelCardSessionInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       Role2ChangeModelCardSessionInfo.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return Role2ChangeModelCardSessionInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return Role2ChangeModelCardSessionInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       Role2ChangeModelCardSessionInfo.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return Role2ChangeModelCardSessionInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return Role2ChangeModelCardSessionInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return Role2ChangeModelCardSessionInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return Role2ChangeModelCardSessionInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return Role2ChangeModelCardSessionInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return Role2ChangeModelCardSessionInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return Role2ChangeModelCardSessionInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Role2ChangeModelCardSessionInfo
/*     */   {
/*     */     private long main_session_id;
/*     */     
/*     */     private long expire_notify_session_id;
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
/*     */     Data(xbean.Role2ChangeModelCardSessionInfo _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof Role2ChangeModelCardSessionInfo)) { assign((Role2ChangeModelCardSessionInfo)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof Role2ChangeModelCardSessionInfo.Const)) assign(((Role2ChangeModelCardSessionInfo.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Role2ChangeModelCardSessionInfo _o_) {
/* 492 */       this.main_session_id = _o_.main_session_id;
/* 493 */       this.expire_notify_session_id = _o_.expire_notify_session_id;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.main_session_id = _o_.main_session_id;
/* 499 */       this.expire_notify_session_id = _o_.expire_notify_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.main_session_id);
/* 506 */       _os_.marshal(this.expire_notify_session_id);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.main_session_id = _os_.unmarshal_long();
/* 514 */       this.expire_notify_session_id = _os_.unmarshal_long();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeInt64Size(1, this.main_session_id);
/* 523 */       _size_ += CodedOutputStream.computeInt64Size(2, this.expire_notify_session_id);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeInt64(1, this.main_session_id);
/* 533 */         _output_.writeInt64(2, this.expire_notify_session_id);
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
/* 560 */             this.main_session_id = _input_.readInt64();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 565 */             this.expire_notify_session_id = _input_.readInt64();
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
/*     */     public xbean.Role2ChangeModelCardSessionInfo copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2ChangeModelCardSessionInfo toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Role2ChangeModelCardSessionInfo toBean()
/*     */     {
/* 604 */       return new Role2ChangeModelCardSessionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2ChangeModelCardSessionInfo toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Role2ChangeModelCardSessionInfo toBeanIf()
/*     */     {
/* 615 */       return new Role2ChangeModelCardSessionInfo(this, null, null);
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
/*     */     public long getMain_session_id()
/*     */     {
/* 652 */       return this.main_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getExpire_notify_session_id()
/*     */     {
/* 659 */       return this.expire_notify_session_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMain_session_id(long _v_)
/*     */     {
/* 666 */       this.main_session_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setExpire_notify_session_id(long _v_)
/*     */     {
/* 673 */       this.expire_notify_session_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.main_session_id != _o_.main_session_id) return false;
/* 682 */       if (this.expire_notify_session_id != _o_.expire_notify_session_id) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ = (int)(_h_ + this.main_session_id);
/* 691 */       _h_ = (int)(_h_ + this.expire_notify_session_id);
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.main_session_id);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.expire_notify_session_id);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2ChangeModelCardSessionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */