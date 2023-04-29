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
/*     */ public final class MassWeddingRedgift extends XBean implements xbean.MassWeddingRedgift
/*     */ {
/*     */   private int redgiftcfgid;
/*     */   private int taken;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  20 */     this.redgiftcfgid = 0;
/*  21 */     this.taken = 0;
/*     */   }
/*     */   
/*     */   MassWeddingRedgift(int __, XBean _xp_, String _vn_)
/*     */   {
/*  26 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public MassWeddingRedgift()
/*     */   {
/*  31 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MassWeddingRedgift(MassWeddingRedgift _o_)
/*     */   {
/*  36 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MassWeddingRedgift(xbean.MassWeddingRedgift _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  41 */     super(_xp_, _vn_);
/*  42 */     if ((_o1_ instanceof MassWeddingRedgift)) { assign((MassWeddingRedgift)_o1_);
/*  43 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  44 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  45 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MassWeddingRedgift _o_) {
/*  50 */     _o_._xdb_verify_unsafe_();
/*  51 */     this.redgiftcfgid = _o_.redgiftcfgid;
/*  52 */     this.taken = _o_.taken;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  57 */     this.redgiftcfgid = _o_.redgiftcfgid;
/*  58 */     this.taken = _o_.taken;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  64 */     _xdb_verify_unsafe_();
/*  65 */     _os_.marshal(this.redgiftcfgid);
/*  66 */     _os_.marshal(this.taken);
/*  67 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  73 */     _xdb_verify_unsafe_();
/*  74 */     this.redgiftcfgid = _os_.unmarshal_int();
/*  75 */     this.taken = _os_.unmarshal_int();
/*  76 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  82 */     _xdb_verify_unsafe_();
/*  83 */     int _size_ = 0;
/*  84 */     _size_ += CodedOutputStream.computeInt32Size(1, this.redgiftcfgid);
/*  85 */     _size_ += CodedOutputStream.computeInt32Size(2, this.taken);
/*  86 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  92 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  95 */       _output_.writeInt32(1, this.redgiftcfgid);
/*  96 */       _output_.writeInt32(2, this.taken);
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
/* 124 */           this.redgiftcfgid = _input_.readInt32();
/* 125 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 129 */           this.taken = _input_.readInt32();
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
/*     */   public xbean.MassWeddingRedgift copy()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new MassWeddingRedgift(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRedgift toData()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWeddingRedgift toBean()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new MassWeddingRedgift(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MassWeddingRedgift toDataIf()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MassWeddingRedgift toBeanIf()
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
/*     */   public int getRedgiftcfgid()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return this.redgiftcfgid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getTaken()
/*     */   {
/* 206 */     _xdb_verify_unsafe_();
/* 207 */     return this.taken;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setRedgiftcfgid(int _v_)
/*     */   {
/* 214 */     _xdb_verify_unsafe_();
/* 215 */     xdb.Logs.logIf(new LogKey(this, "redgiftcfgid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 219 */         new xdb.logs.LogInt(this, MassWeddingRedgift.this.redgiftcfgid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 223 */             MassWeddingRedgift.this.redgiftcfgid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 227 */     });
/* 228 */     this.redgiftcfgid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setTaken(int _v_)
/*     */   {
/* 235 */     _xdb_verify_unsafe_();
/* 236 */     xdb.Logs.logIf(new LogKey(this, "taken")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 240 */         new xdb.logs.LogInt(this, MassWeddingRedgift.this.taken)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 244 */             MassWeddingRedgift.this.taken = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 248 */     });
/* 249 */     this.taken = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 255 */     _xdb_verify_unsafe_();
/* 256 */     MassWeddingRedgift _o_ = null;
/* 257 */     if ((_o1_ instanceof MassWeddingRedgift)) { _o_ = (MassWeddingRedgift)_o1_;
/* 258 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 259 */       return false;
/* 260 */     if (this.redgiftcfgid != _o_.redgiftcfgid) return false;
/* 261 */     if (this.taken != _o_.taken) return false;
/* 262 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 268 */     _xdb_verify_unsafe_();
/* 269 */     int _h_ = 0;
/* 270 */     _h_ += this.redgiftcfgid;
/* 271 */     _h_ += this.taken;
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append(this.redgiftcfgid);
/* 282 */     _sb_.append(",");
/* 283 */     _sb_.append(this.taken);
/* 284 */     _sb_.append(")");
/* 285 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 291 */     ListenableBean lb = new ListenableBean();
/* 292 */     lb.add(new xdb.logs.ListenableChanged().setVarName("redgiftcfgid"));
/* 293 */     lb.add(new xdb.logs.ListenableChanged().setVarName("taken"));
/* 294 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MassWeddingRedgift {
/*     */     private Const() {}
/*     */     
/*     */     MassWeddingRedgift nThis() {
/* 301 */       return MassWeddingRedgift.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 307 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRedgift copy()
/*     */     {
/* 313 */       return MassWeddingRedgift.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRedgift toData()
/*     */     {
/* 319 */       return MassWeddingRedgift.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRedgift toBean()
/*     */     {
/* 324 */       return MassWeddingRedgift.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRedgift toDataIf()
/*     */     {
/* 330 */       return MassWeddingRedgift.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRedgift toBeanIf()
/*     */     {
/* 335 */       return MassWeddingRedgift.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getRedgiftcfgid()
/*     */     {
/* 342 */       MassWeddingRedgift.this._xdb_verify_unsafe_();
/* 343 */       return MassWeddingRedgift.this.redgiftcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTaken()
/*     */     {
/* 350 */       MassWeddingRedgift.this._xdb_verify_unsafe_();
/* 351 */       return MassWeddingRedgift.this.taken;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRedgiftcfgid(int _v_)
/*     */     {
/* 358 */       MassWeddingRedgift.this._xdb_verify_unsafe_();
/* 359 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTaken(int _v_)
/*     */     {
/* 366 */       MassWeddingRedgift.this._xdb_verify_unsafe_();
/* 367 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 373 */       MassWeddingRedgift.this._xdb_verify_unsafe_();
/* 374 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 380 */       MassWeddingRedgift.this._xdb_verify_unsafe_();
/* 381 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 387 */       return MassWeddingRedgift.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 393 */       return MassWeddingRedgift.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 399 */       MassWeddingRedgift.this._xdb_verify_unsafe_();
/* 400 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 406 */       return MassWeddingRedgift.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 412 */       return MassWeddingRedgift.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 418 */       MassWeddingRedgift.this._xdb_verify_unsafe_();
/* 419 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 425 */       return MassWeddingRedgift.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 431 */       return MassWeddingRedgift.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 437 */       return MassWeddingRedgift.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 443 */       return MassWeddingRedgift.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 449 */       return MassWeddingRedgift.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 455 */       return MassWeddingRedgift.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 461 */       return MassWeddingRedgift.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MassWeddingRedgift
/*     */   {
/*     */     private int redgiftcfgid;
/*     */     
/*     */     private int taken;
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
/*     */     Data(xbean.MassWeddingRedgift _o1_)
/*     */     {
/* 484 */       if ((_o1_ instanceof MassWeddingRedgift)) { assign((MassWeddingRedgift)_o1_);
/* 485 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 486 */       } else if ((_o1_ instanceof MassWeddingRedgift.Const)) assign(((MassWeddingRedgift.Const)_o1_).nThis()); else {
/* 487 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MassWeddingRedgift _o_) {
/* 492 */       this.redgiftcfgid = _o_.redgiftcfgid;
/* 493 */       this.taken = _o_.taken;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 498 */       this.redgiftcfgid = _o_.redgiftcfgid;
/* 499 */       this.taken = _o_.taken;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 505 */       _os_.marshal(this.redgiftcfgid);
/* 506 */       _os_.marshal(this.taken);
/* 507 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 513 */       this.redgiftcfgid = _os_.unmarshal_int();
/* 514 */       this.taken = _os_.unmarshal_int();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeInt32Size(1, this.redgiftcfgid);
/* 523 */       _size_ += CodedOutputStream.computeInt32Size(2, this.taken);
/* 524 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 532 */         _output_.writeInt32(1, this.redgiftcfgid);
/* 533 */         _output_.writeInt32(2, this.taken);
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
/* 560 */             this.redgiftcfgid = _input_.readInt32();
/* 561 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 565 */             this.taken = _input_.readInt32();
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
/*     */     public xbean.MassWeddingRedgift copy()
/*     */     {
/* 593 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRedgift toData()
/*     */     {
/* 599 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRedgift toBean()
/*     */     {
/* 604 */       return new MassWeddingRedgift(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MassWeddingRedgift toDataIf()
/*     */     {
/* 610 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MassWeddingRedgift toBeanIf()
/*     */     {
/* 615 */       return new MassWeddingRedgift(this, null, null);
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
/*     */     public int getRedgiftcfgid()
/*     */     {
/* 652 */       return this.redgiftcfgid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getTaken()
/*     */     {
/* 659 */       return this.taken;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setRedgiftcfgid(int _v_)
/*     */     {
/* 666 */       this.redgiftcfgid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setTaken(int _v_)
/*     */     {
/* 673 */       this.taken = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 679 */       if (!(_o1_ instanceof Data)) return false;
/* 680 */       Data _o_ = (Data)_o1_;
/* 681 */       if (this.redgiftcfgid != _o_.redgiftcfgid) return false;
/* 682 */       if (this.taken != _o_.taken) return false;
/* 683 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 689 */       int _h_ = 0;
/* 690 */       _h_ += this.redgiftcfgid;
/* 691 */       _h_ += this.taken;
/* 692 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 698 */       StringBuilder _sb_ = new StringBuilder();
/* 699 */       _sb_.append("(");
/* 700 */       _sb_.append(this.redgiftcfgid);
/* 701 */       _sb_.append(",");
/* 702 */       _sb_.append(this.taken);
/* 703 */       _sb_.append(")");
/* 704 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MassWeddingRedgift.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */