/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.Log;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class MassWeddingRankInfo extends XBean implements xbean.MassWeddingRankInfo
/*     */ {
/*     */   private long roleida;
/*     */   private int roleaoffer;
/*     */   private long roleidb;
/*     */   private int roleidboffer;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.roleida = 0L;
/*  25 */     this.roleaoffer = 0;
/*  26 */     this.roleidb = 0L;
/*  27 */     this.roleidboffer = 0;
/*     */   }
/*     */   
/*     */   MassWeddingRankInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public MassWeddingRankInfo()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MassWeddingRankInfo(MassWeddingRankInfo _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MassWeddingRankInfo(xbean.MassWeddingRankInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof MassWeddingRankInfo)) { assign((MassWeddingRankInfo)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MassWeddingRankInfo _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.roleida = _o_.roleida;
/*  58 */     this.roleaoffer = _o_.roleaoffer;
/*  59 */     this.roleidb = _o_.roleidb;
/*  60 */     this.roleidboffer = _o_.roleidboffer;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.roleida = _o_.roleida;
/*  66 */     this.roleaoffer = _o_.roleaoffer;
/*  67 */     this.roleidb = _o_.roleidb;
/*  68 */     this.roleidboffer = _o_.roleidboffer;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.roleida);
/*  76 */     _os_.marshal(this.roleaoffer);
/*  77 */     _os_.marshal(this.roleidb);
/*  78 */     _os_.marshal(this.roleidboffer);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.roleida = _os_.unmarshal_long();
/*  87 */     this.roleaoffer = _os_.unmarshal_int();
/*  88 */     this.roleidb = _os_.unmarshal_long();
/*  89 */     this.roleidboffer = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleida);
/*  99 */     _size_ += CodedOutputStream.computeInt32Size(2, this.roleaoffer);
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(3, this.roleidb);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(4, this.roleidboffer);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt64(1, this.roleida);
/* 112 */       _output_.writeInt32(2, this.roleaoffer);
/* 113 */       _output_.writeInt64(3, this.roleidb);
/* 114 */       _output_.writeInt32(4, this.roleidboffer);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 118 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 120 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 126 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 129 */       boolean done = false;
/* 130 */       while (!done)
/*     */       {
/* 132 */         int tag = _input_.readTag();
/* 133 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 137 */           done = true;
/* 138 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 142 */           this.roleida = _input_.readInt64();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.roleaoffer = _input_.readInt32();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.roleidb = _input_.readInt64();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.roleidboffer = _input_.readInt32();
/* 158 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 162 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 164 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 173 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 177 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 179 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRankInfo copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new MassWeddingRankInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRankInfo toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWeddingRankInfo toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new MassWeddingRankInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRankInfo toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWeddingRankInfo toBeanIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 218 */     _xdb_verify_unsafe_();
/* 219 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleida()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.roleida;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRoleaoffer()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.roleaoffer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getRoleidb()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.roleidb;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getRoleidboffer()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.roleidboffer;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleida(long _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "roleida")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 263 */         new xdb.logs.LogLong(this, MassWeddingRankInfo.this.roleida)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             MassWeddingRankInfo.this.roleida = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.roleida = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleaoffer(int _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "roleaoffer")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 284 */         new xdb.logs.LogInt(this, MassWeddingRankInfo.this.roleaoffer)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             MassWeddingRankInfo.this.roleaoffer = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.roleaoffer = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleidb(long _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "roleidb")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 305 */         new xdb.logs.LogLong(this, MassWeddingRankInfo.this.roleidb)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             MassWeddingRankInfo.this.roleidb = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.roleidb = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRoleidboffer(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "roleidboffer")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 326 */         new xdb.logs.LogInt(this, MassWeddingRankInfo.this.roleidboffer)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             MassWeddingRankInfo.this.roleidboffer = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.roleidboffer = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     MassWeddingRankInfo _o_ = null;
/* 343 */     if ((_o1_ instanceof MassWeddingRankInfo)) { _o_ = (MassWeddingRankInfo)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.roleida != _o_.roleida) return false;
/* 347 */     if (this.roleaoffer != _o_.roleaoffer) return false;
/* 348 */     if (this.roleidb != _o_.roleidb) return false;
/* 349 */     if (this.roleidboffer != _o_.roleidboffer) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ = (int)(_h_ + this.roleida);
/* 359 */     _h_ += this.roleaoffer;
/* 360 */     _h_ = (int)(_h_ + this.roleidb);
/* 361 */     _h_ += this.roleidboffer;
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.roleida);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.roleaoffer);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.roleidb);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.roleidboffer);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("roleida"));
/* 387 */     lb.add(new ListenableChanged().setVarName("roleaoffer"));
/* 388 */     lb.add(new ListenableChanged().setVarName("roleidb"));
/* 389 */     lb.add(new ListenableChanged().setVarName("roleidboffer"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MassWeddingRankInfo {
/*     */     private Const() {}
/*     */     
/*     */     MassWeddingRankInfo nThis() {
/* 397 */       return MassWeddingRankInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfo copy()
/*     */     {
/* 409 */       return MassWeddingRankInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfo toData()
/*     */     {
/* 415 */       return MassWeddingRankInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRankInfo toBean()
/*     */     {
/* 420 */       return MassWeddingRankInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfo toDataIf()
/*     */     {
/* 426 */       return MassWeddingRankInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRankInfo toBeanIf()
/*     */     {
/* 431 */       return MassWeddingRankInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleida()
/*     */     {
/* 438 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 439 */       return MassWeddingRankInfo.this.roleida;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRoleaoffer()
/*     */     {
/* 446 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 447 */       return MassWeddingRankInfo.this.roleaoffer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleidb()
/*     */     {
/* 454 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 455 */       return MassWeddingRankInfo.this.roleidb;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRoleidboffer()
/*     */     {
/* 462 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 463 */       return MassWeddingRankInfo.this.roleidboffer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleida(long _v_)
/*     */     {
/* 470 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleaoffer(int _v_)
/*     */     {
/* 478 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleidb(long _v_)
/*     */     {
/* 486 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleidboffer(int _v_)
/*     */     {
/* 494 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return MassWeddingRankInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return MassWeddingRankInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return MassWeddingRankInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return MassWeddingRankInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       MassWeddingRankInfo.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return MassWeddingRankInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return MassWeddingRankInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return MassWeddingRankInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return MassWeddingRankInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return MassWeddingRankInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return MassWeddingRankInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return MassWeddingRankInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MassWeddingRankInfo
/*     */   {
/*     */     private long roleida;
/*     */     
/*     */     private int roleaoffer;
/*     */     
/*     */     private long roleidb;
/*     */     
/*     */     private int roleidboffer;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 607 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.MassWeddingRankInfo _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof MassWeddingRankInfo)) { assign((MassWeddingRankInfo)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof MassWeddingRankInfo.Const)) assign(((MassWeddingRankInfo.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MassWeddingRankInfo _o_) {
/* 624 */       this.roleida = _o_.roleida;
/* 625 */       this.roleaoffer = _o_.roleaoffer;
/* 626 */       this.roleidb = _o_.roleidb;
/* 627 */       this.roleidboffer = _o_.roleidboffer;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.roleida = _o_.roleida;
/* 633 */       this.roleaoffer = _o_.roleaoffer;
/* 634 */       this.roleidb = _o_.roleidb;
/* 635 */       this.roleidboffer = _o_.roleidboffer;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.roleida);
/* 642 */       _os_.marshal(this.roleaoffer);
/* 643 */       _os_.marshal(this.roleidb);
/* 644 */       _os_.marshal(this.roleidboffer);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.roleida = _os_.unmarshal_long();
/* 652 */       this.roleaoffer = _os_.unmarshal_int();
/* 653 */       this.roleidb = _os_.unmarshal_long();
/* 654 */       this.roleidboffer = _os_.unmarshal_int();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleida);
/* 663 */       _size_ += CodedOutputStream.computeInt32Size(2, this.roleaoffer);
/* 664 */       _size_ += CodedOutputStream.computeInt64Size(3, this.roleidb);
/* 665 */       _size_ += CodedOutputStream.computeInt32Size(4, this.roleidboffer);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt64(1, this.roleida);
/* 675 */         _output_.writeInt32(2, this.roleaoffer);
/* 676 */         _output_.writeInt64(3, this.roleidb);
/* 677 */         _output_.writeInt32(4, this.roleidboffer);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 681 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 683 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 691 */         boolean done = false;
/* 692 */         while (!done)
/*     */         {
/* 694 */           int tag = _input_.readTag();
/* 695 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 699 */             done = true;
/* 700 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 704 */             this.roleida = _input_.readInt64();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.roleaoffer = _input_.readInt32();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.roleidb = _input_.readInt64();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.roleidboffer = _input_.readInt32();
/* 720 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 724 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 726 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 735 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 739 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 741 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfo copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfo toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRankInfo toBean()
/*     */     {
/* 758 */       return new MassWeddingRankInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRankInfo toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRankInfo toBeanIf()
/*     */     {
/* 769 */       return new MassWeddingRankInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 775 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 779 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 783 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 787 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 791 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 795 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 799 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleida()
/*     */     {
/* 806 */       return this.roleida;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRoleaoffer()
/*     */     {
/* 813 */       return this.roleaoffer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getRoleidb()
/*     */     {
/* 820 */       return this.roleidb;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRoleidboffer()
/*     */     {
/* 827 */       return this.roleidboffer;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleida(long _v_)
/*     */     {
/* 834 */       this.roleida = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleaoffer(int _v_)
/*     */     {
/* 841 */       this.roleaoffer = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleidb(long _v_)
/*     */     {
/* 848 */       this.roleidb = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRoleidboffer(int _v_)
/*     */     {
/* 855 */       this.roleidboffer = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.roleida != _o_.roleida) return false;
/* 864 */       if (this.roleaoffer != _o_.roleaoffer) return false;
/* 865 */       if (this.roleidb != _o_.roleidb) return false;
/* 866 */       if (this.roleidboffer != _o_.roleidboffer) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ = (int)(_h_ + this.roleida);
/* 875 */       _h_ += this.roleaoffer;
/* 876 */       _h_ = (int)(_h_ + this.roleidb);
/* 877 */       _h_ += this.roleidboffer;
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.roleida);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.roleaoffer);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.roleidb);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.roleidboffer);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MassWeddingRankInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */