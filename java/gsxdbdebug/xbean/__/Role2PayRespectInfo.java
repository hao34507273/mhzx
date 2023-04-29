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
/*     */ public final class Role2PayRespectInfo extends XBean implements xbean.Role2PayRespectInfo
/*     */ {
/*     */   private boolean master_is_paying_respect;
/*     */   private boolean apprentice_is_paying_respect;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.master_is_paying_respect = false;
/*  21 */     this.apprentice_is_paying_respect = false;
/*     */   }
/*     */   
/*     */   Role2PayRespectInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public Role2PayRespectInfo()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public Role2PayRespectInfo(Role2PayRespectInfo _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   Role2PayRespectInfo(xbean.Role2PayRespectInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof Role2PayRespectInfo)) { assign((Role2PayRespectInfo)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(Role2PayRespectInfo _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.master_is_paying_respect = _o_.master_is_paying_respect;
/*  52 */     this.apprentice_is_paying_respect = _o_.apprentice_is_paying_respect;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.master_is_paying_respect = _o_.master_is_paying_respect;
/*  58 */     this.apprentice_is_paying_respect = _o_.apprentice_is_paying_respect;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.master_is_paying_respect);
/*  66 */     _os_.marshal(this.apprentice_is_paying_respect);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.master_is_paying_respect = _os_.unmarshal_boolean();
/*  75 */     this.apprentice_is_paying_respect = _os_.unmarshal_boolean();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeBoolSize(1, this.master_is_paying_respect);
/*  85 */     _size_ += CodedOutputStream.computeBoolSize(2, this.apprentice_is_paying_respect);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeBool(1, this.master_is_paying_respect);
/*  96 */       _output_.writeBool(2, this.apprentice_is_paying_respect);
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
/* 124 */           this.master_is_paying_respect = _input_.readBool();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 129 */           this.apprentice_is_paying_respect = _input_.readBool();
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
/*     */   public xbean.Role2PayRespectInfo copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new Role2PayRespectInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2PayRespectInfo toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2PayRespectInfo toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new Role2PayRespectInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.Role2PayRespectInfo toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.Role2PayRespectInfo toBeanIf()
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
/*     */   public boolean getMaster_is_paying_respect()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.master_is_paying_respect;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getApprentice_is_paying_respect()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.apprentice_is_paying_respect;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setMaster_is_paying_respect(boolean _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "master_is_paying_respect")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new xdb.logs.LogObject(this, Boolean.valueOf(Role2PayRespectInfo.this.master_is_paying_respect))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             Role2PayRespectInfo.this.master_is_paying_respect = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.master_is_paying_respect = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setApprentice_is_paying_respect(boolean _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "apprentice_is_paying_respect")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new xdb.logs.LogObject(this, Boolean.valueOf(Role2PayRespectInfo.this.apprentice_is_paying_respect))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             Role2PayRespectInfo.this.apprentice_is_paying_respect = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.apprentice_is_paying_respect = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     Role2PayRespectInfo _o_ = null;
/* 257 */     if ((_o1_ instanceof Role2PayRespectInfo)) { _o_ = (Role2PayRespectInfo)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.master_is_paying_respect != _o_.master_is_paying_respect) return false;
/* 261 */     if (this.apprentice_is_paying_respect != _o_.apprentice_is_paying_respect) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ += (this.master_is_paying_respect ? 1231 : 1237);
/* 271 */     _h_ += (this.apprentice_is_paying_respect ? 1231 : 1237);
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.master_is_paying_respect);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.apprentice_is_paying_respect);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     ListenableBean lb = new ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("master_is_paying_respect"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("apprentice_is_paying_respect"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.Role2PayRespectInfo {
/*     */     private Const() {}
/*     */     
/*     */     Role2PayRespectInfo nThis() {
/* 301 */       return Role2PayRespectInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PayRespectInfo copy()
/*     */     {
/* 313 */       return Role2PayRespectInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PayRespectInfo toData()
/*     */     {
/* 319 */       return Role2PayRespectInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.Role2PayRespectInfo toBean()
/*     */     {
/* 324 */       return Role2PayRespectInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PayRespectInfo toDataIf()
/*     */     {
/* 330 */       return Role2PayRespectInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.Role2PayRespectInfo toBeanIf()
/*     */     {
/* 335 */       return Role2PayRespectInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getMaster_is_paying_respect()
/*     */     {
/* 342 */       Role2PayRespectInfo.this._xdb_verify_unsafe_();
/* 343 */       return Role2PayRespectInfo.this.master_is_paying_respect;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getApprentice_is_paying_respect()
/*     */     {
/* 350 */       Role2PayRespectInfo.this._xdb_verify_unsafe_();
/* 351 */       return Role2PayRespectInfo.this.apprentice_is_paying_respect;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMaster_is_paying_respect(boolean _v_)
/*     */     {
/* 358 */       Role2PayRespectInfo.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setApprentice_is_paying_respect(boolean _v_)
/*     */     {
/* 366 */       Role2PayRespectInfo.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       Role2PayRespectInfo.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       Role2PayRespectInfo.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return Role2PayRespectInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return Role2PayRespectInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       Role2PayRespectInfo.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return Role2PayRespectInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return Role2PayRespectInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       Role2PayRespectInfo.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return Role2PayRespectInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return Role2PayRespectInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return Role2PayRespectInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return Role2PayRespectInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return Role2PayRespectInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return Role2PayRespectInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return Role2PayRespectInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.Role2PayRespectInfo
/*     */   {
/*     */     private boolean master_is_paying_respect;
/*     */     
/*     */     private boolean apprentice_is_paying_respect;
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
/*     */     Data(xbean.Role2PayRespectInfo _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof Role2PayRespectInfo)) { assign((Role2PayRespectInfo)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof Role2PayRespectInfo.Const)) assign(((Role2PayRespectInfo.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(Role2PayRespectInfo _o_) {
/* 492 */       this.master_is_paying_respect = _o_.master_is_paying_respect;
/* 493 */       this.apprentice_is_paying_respect = _o_.apprentice_is_paying_respect;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.master_is_paying_respect = _o_.master_is_paying_respect;
/* 499 */       this.apprentice_is_paying_respect = _o_.apprentice_is_paying_respect;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.master_is_paying_respect);
/* 506 */       _os_.marshal(this.apprentice_is_paying_respect);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.master_is_paying_respect = _os_.unmarshal_boolean();
/* 514 */       this.apprentice_is_paying_respect = _os_.unmarshal_boolean();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeBoolSize(1, this.master_is_paying_respect);
/* 523 */       _size_ += CodedOutputStream.computeBoolSize(2, this.apprentice_is_paying_respect);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeBool(1, this.master_is_paying_respect);
/* 533 */         _output_.writeBool(2, this.apprentice_is_paying_respect);
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
/* 560 */             this.master_is_paying_respect = _input_.readBool();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 565 */             this.apprentice_is_paying_respect = _input_.readBool();
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
/*     */     public xbean.Role2PayRespectInfo copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PayRespectInfo toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.Role2PayRespectInfo toBean()
/*     */     {
/* 604 */       return new Role2PayRespectInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.Role2PayRespectInfo toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.Role2PayRespectInfo toBeanIf()
/*     */     {
/* 615 */       return new Role2PayRespectInfo(this, null, null);
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
/*     */     public boolean getMaster_is_paying_respect()
/*     */     {
/* 652 */       return this.master_is_paying_respect;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getApprentice_is_paying_respect()
/*     */     {
/* 659 */       return this.apprentice_is_paying_respect;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setMaster_is_paying_respect(boolean _v_)
/*     */     {
/* 666 */       this.master_is_paying_respect = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setApprentice_is_paying_respect(boolean _v_)
/*     */     {
/* 673 */       this.apprentice_is_paying_respect = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.master_is_paying_respect != _o_.master_is_paying_respect) return false;
/* 682 */       if (this.apprentice_is_paying_respect != _o_.apprentice_is_paying_respect) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ += (this.master_is_paying_respect ? 1231 : 1237);
/* 691 */       _h_ += (this.apprentice_is_paying_respect ? 1231 : 1237);
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.master_is_paying_respect);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.apprentice_is_paying_respect);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Role2PayRespectInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */