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
/*     */ 
/*     */ public final class GlobleKeJuInfo extends XBean implements xbean.GlobleKeJuInfo
/*     */ {
/*     */   private long worldid;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.worldid = -1L;
/*     */   }
/*     */   
/*     */   GlobleKeJuInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.worldid = -1L;
/*     */   }
/*     */   
/*     */   public GlobleKeJuInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public GlobleKeJuInfo(GlobleKeJuInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   GlobleKeJuInfo(xbean.GlobleKeJuInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof GlobleKeJuInfo)) { assign((GlobleKeJuInfo)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(GlobleKeJuInfo _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.worldid = _o_.worldid;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  54 */     this.worldid = _o_.worldid;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  60 */     _xdb_verify_unsafe_();
/*  61 */     _os_.marshal(this.worldid);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  68 */     _xdb_verify_unsafe_();
/*  69 */     this.worldid = _os_.unmarshal_long();
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     int _size_ = 0;
/*  78 */     _size_ += CodedOutputStream.computeInt64Size(3, this.worldid);
/*  79 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  88 */       _output_.writeInt64(3, this.worldid);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  92 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/*  94 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 100 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 103 */       boolean done = false;
/* 104 */       while (!done)
/*     */       {
/* 106 */         int tag = _input_.readTag();
/* 107 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 111 */           done = true;
/* 112 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 116 */           this.worldid = _input_.readInt64();
/* 117 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 121 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 123 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 132 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 138 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobleKeJuInfo copy()
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/* 145 */     return new GlobleKeJuInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobleKeJuInfo toData()
/*     */   {
/* 151 */     _xdb_verify_unsafe_();
/* 152 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GlobleKeJuInfo toBean()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new GlobleKeJuInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.GlobleKeJuInfo toDataIf()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.GlobleKeJuInfo toBeanIf()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getWorldid()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return this.worldid;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setWorldid(long _v_)
/*     */   {
/* 193 */     _xdb_verify_unsafe_();
/* 194 */     xdb.Logs.logIf(new LogKey(this, "worldid")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 198 */         new xdb.logs.LogLong(this, GlobleKeJuInfo.this.worldid)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 202 */             GlobleKeJuInfo.this.worldid = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 206 */     });
/* 207 */     this.worldid = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     GlobleKeJuInfo _o_ = null;
/* 215 */     if ((_o1_ instanceof GlobleKeJuInfo)) { _o_ = (GlobleKeJuInfo)_o1_;
/* 216 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 217 */       return false;
/* 218 */     if (this.worldid != _o_.worldid) return false;
/* 219 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 225 */     _xdb_verify_unsafe_();
/* 226 */     int _h_ = 0;
/* 227 */     _h_ = (int)(_h_ + this.worldid);
/* 228 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     StringBuilder _sb_ = new StringBuilder();
/* 236 */     _sb_.append("(");
/* 237 */     _sb_.append(this.worldid);
/* 238 */     _sb_.append(")");
/* 239 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 245 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 246 */     lb.add(new xdb.logs.ListenableChanged().setVarName("worldid"));
/* 247 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.GlobleKeJuInfo {
/*     */     private Const() {}
/*     */     
/*     */     GlobleKeJuInfo nThis() {
/* 254 */       return GlobleKeJuInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 260 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobleKeJuInfo copy()
/*     */     {
/* 266 */       return GlobleKeJuInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobleKeJuInfo toData()
/*     */     {
/* 272 */       return GlobleKeJuInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.GlobleKeJuInfo toBean()
/*     */     {
/* 277 */       return GlobleKeJuInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobleKeJuInfo toDataIf()
/*     */     {
/* 283 */       return GlobleKeJuInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.GlobleKeJuInfo toBeanIf()
/*     */     {
/* 288 */       return GlobleKeJuInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorldid()
/*     */     {
/* 295 */       GlobleKeJuInfo.this._xdb_verify_unsafe_();
/* 296 */       return GlobleKeJuInfo.this.worldid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorldid(long _v_)
/*     */     {
/* 303 */       GlobleKeJuInfo.this._xdb_verify_unsafe_();
/* 304 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 310 */       GlobleKeJuInfo.this._xdb_verify_unsafe_();
/* 311 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 317 */       GlobleKeJuInfo.this._xdb_verify_unsafe_();
/* 318 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 324 */       return GlobleKeJuInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 330 */       return GlobleKeJuInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 336 */       GlobleKeJuInfo.this._xdb_verify_unsafe_();
/* 337 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 343 */       return GlobleKeJuInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 349 */       return GlobleKeJuInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 355 */       GlobleKeJuInfo.this._xdb_verify_unsafe_();
/* 356 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 362 */       return GlobleKeJuInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 368 */       return GlobleKeJuInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 374 */       return GlobleKeJuInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 380 */       return GlobleKeJuInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 386 */       return GlobleKeJuInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 392 */       return GlobleKeJuInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 398 */       return GlobleKeJuInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.GlobleKeJuInfo
/*     */   {
/*     */     private long worldid;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 410 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 415 */       this.worldid = -1L;
/*     */     }
/*     */     
/*     */     Data(xbean.GlobleKeJuInfo _o1_)
/*     */     {
/* 420 */       if ((_o1_ instanceof GlobleKeJuInfo)) { assign((GlobleKeJuInfo)_o1_);
/* 421 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 422 */       } else if ((_o1_ instanceof GlobleKeJuInfo.Const)) assign(((GlobleKeJuInfo.Const)_o1_).nThis()); else {
/* 423 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(GlobleKeJuInfo _o_) {
/* 428 */       this.worldid = _o_.worldid;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 433 */       this.worldid = _o_.worldid;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 439 */       _os_.marshal(this.worldid);
/* 440 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 446 */       this.worldid = _os_.unmarshal_long();
/* 447 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 453 */       int _size_ = 0;
/* 454 */       _size_ += CodedOutputStream.computeInt64Size(3, this.worldid);
/* 455 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 463 */         _output_.writeInt64(3, this.worldid);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 467 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 469 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 477 */         boolean done = false;
/* 478 */         while (!done)
/*     */         {
/* 480 */           int tag = _input_.readTag();
/* 481 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 485 */             done = true;
/* 486 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 490 */             this.worldid = _input_.readInt64();
/* 491 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 495 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 497 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 506 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 510 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 512 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobleKeJuInfo copy()
/*     */     {
/* 518 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobleKeJuInfo toData()
/*     */     {
/* 524 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.GlobleKeJuInfo toBean()
/*     */     {
/* 529 */       return new GlobleKeJuInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.GlobleKeJuInfo toDataIf()
/*     */     {
/* 535 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.GlobleKeJuInfo toBeanIf()
/*     */     {
/* 540 */       return new GlobleKeJuInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 546 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 550 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 554 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 558 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 562 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 566 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 570 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getWorldid()
/*     */     {
/* 577 */       return this.worldid;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setWorldid(long _v_)
/*     */     {
/* 584 */       this.worldid = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 590 */       if (!(_o1_ instanceof Data)) return false;
/* 591 */       Data _o_ = (Data)_o1_;
/* 592 */       if (this.worldid != _o_.worldid) return false;
/* 593 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 599 */       int _h_ = 0;
/* 600 */       _h_ = (int)(_h_ + this.worldid);
/* 601 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 607 */       StringBuilder _sb_ = new StringBuilder();
/* 608 */       _sb_.append("(");
/* 609 */       _sb_.append(this.worldid);
/* 610 */       _sb_.append(")");
/* 611 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\GlobleKeJuInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */