/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.Bean;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableBean;
/*     */ 
/*     */ public final class BackGameActivityUserInfo extends XBean implements xbean.BackGameActivityUserInfo
/*     */ {
/*     */   private xbean.BackGameActivityRechargeInfo rechargeinfo;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.rechargeinfo._reset_unsafe_();
/*     */   }
/*     */   
/*     */   BackGameActivityUserInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.rechargeinfo = new BackGameActivityRechargeInfo(0, this, "rechargeinfo");
/*     */   }
/*     */   
/*     */   public BackGameActivityUserInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public BackGameActivityUserInfo(BackGameActivityUserInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   BackGameActivityUserInfo(xbean.BackGameActivityUserInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof BackGameActivityUserInfo)) { assign((BackGameActivityUserInfo)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(BackGameActivityUserInfo _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.rechargeinfo = new BackGameActivityRechargeInfo(_o_.rechargeinfo, this, "rechargeinfo");
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  54 */     this.rechargeinfo = new BackGameActivityRechargeInfo(_o_.rechargeinfo, this, "rechargeinfo");
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  60 */     _xdb_verify_unsafe_();
/*  61 */     this.rechargeinfo.marshal(_os_);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  68 */     _xdb_verify_unsafe_();
/*  69 */     this.rechargeinfo.unmarshal(_os_);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     int _size_ = 0;
/*  78 */     _size_ += CodedOutputStream.computeMessageSize(1, this.rechargeinfo);
/*  79 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  88 */       _output_.writeMessage(1, this.rechargeinfo);
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
/*     */         case 10: 
/* 116 */           _input_.readMessage(this.rechargeinfo);
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
/*     */   public xbean.BackGameActivityUserInfo copy()
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/* 145 */     return new BackGameActivityUserInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BackGameActivityUserInfo toData()
/*     */   {
/* 151 */     _xdb_verify_unsafe_();
/* 152 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BackGameActivityUserInfo toBean()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new BackGameActivityUserInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.BackGameActivityUserInfo toDataIf()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.BackGameActivityUserInfo toBeanIf()
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
/*     */   public xbean.BackGameActivityRechargeInfo getRechargeinfo()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return this.rechargeinfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     BackGameActivityUserInfo _o_ = null;
/* 194 */     if ((_o1_ instanceof BackGameActivityUserInfo)) { _o_ = (BackGameActivityUserInfo)_o1_;
/* 195 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 196 */       return false;
/* 197 */     if (!this.rechargeinfo.equals(_o_.rechargeinfo)) return false;
/* 198 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     int _h_ = 0;
/* 206 */     _h_ += this.rechargeinfo.hashCode();
/* 207 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     StringBuilder _sb_ = new StringBuilder();
/* 215 */     _sb_.append("(");
/* 216 */     _sb_.append(this.rechargeinfo);
/* 217 */     _sb_.append(")");
/* 218 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 224 */     ListenableBean lb = new ListenableBean();
/* 225 */     lb.add(new xdb.logs.ListenableChanged().setVarName("rechargeinfo"));
/* 226 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.BackGameActivityUserInfo {
/*     */     private Const() {}
/*     */     
/*     */     BackGameActivityUserInfo nThis() {
/* 233 */       return BackGameActivityUserInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 239 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityUserInfo copy()
/*     */     {
/* 245 */       return BackGameActivityUserInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityUserInfo toData()
/*     */     {
/* 251 */       return BackGameActivityUserInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.BackGameActivityUserInfo toBean()
/*     */     {
/* 256 */       return BackGameActivityUserInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityUserInfo toDataIf()
/*     */     {
/* 262 */       return BackGameActivityUserInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.BackGameActivityUserInfo toBeanIf()
/*     */     {
/* 267 */       return BackGameActivityUserInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.BackGameActivityRechargeInfo getRechargeinfo()
/*     */     {
/* 274 */       BackGameActivityUserInfo.this._xdb_verify_unsafe_();
/* 275 */       return (xbean.BackGameActivityRechargeInfo)xdb.Consts.toConst(BackGameActivityUserInfo.this.rechargeinfo);
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 281 */       BackGameActivityUserInfo.this._xdb_verify_unsafe_();
/* 282 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 288 */       BackGameActivityUserInfo.this._xdb_verify_unsafe_();
/* 289 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 295 */       return BackGameActivityUserInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 301 */       return BackGameActivityUserInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 307 */       BackGameActivityUserInfo.this._xdb_verify_unsafe_();
/* 308 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 314 */       return BackGameActivityUserInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 320 */       return BackGameActivityUserInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 326 */       BackGameActivityUserInfo.this._xdb_verify_unsafe_();
/* 327 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 333 */       return BackGameActivityUserInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 339 */       return BackGameActivityUserInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 345 */       return BackGameActivityUserInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 351 */       return BackGameActivityUserInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 357 */       return BackGameActivityUserInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 363 */       return BackGameActivityUserInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 369 */       return BackGameActivityUserInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.BackGameActivityUserInfo
/*     */   {
/*     */     private xbean.BackGameActivityRechargeInfo rechargeinfo;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 386 */       this.rechargeinfo = new BackGameActivityRechargeInfo.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.BackGameActivityUserInfo _o1_)
/*     */     {
/* 391 */       if ((_o1_ instanceof BackGameActivityUserInfo)) { assign((BackGameActivityUserInfo)_o1_);
/* 392 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 393 */       } else if ((_o1_ instanceof BackGameActivityUserInfo.Const)) assign(((BackGameActivityUserInfo.Const)_o1_).nThis()); else {
/* 394 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(BackGameActivityUserInfo _o_) {
/* 399 */       this.rechargeinfo = new BackGameActivityRechargeInfo.Data(_o_.rechargeinfo);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 404 */       this.rechargeinfo = new BackGameActivityRechargeInfo.Data(_o_.rechargeinfo);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 410 */       this.rechargeinfo.marshal(_os_);
/* 411 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 417 */       this.rechargeinfo.unmarshal(_os_);
/* 418 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 424 */       int _size_ = 0;
/* 425 */       _size_ += CodedOutputStream.computeMessageSize(1, this.rechargeinfo);
/* 426 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 434 */         _output_.writeMessage(1, this.rechargeinfo);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 438 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 440 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 448 */         boolean done = false;
/* 449 */         while (!done)
/*     */         {
/* 451 */           int tag = _input_.readTag();
/* 452 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 456 */             done = true;
/* 457 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 461 */             _input_.readMessage(this.rechargeinfo);
/* 462 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 466 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 468 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 477 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 481 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 483 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityUserInfo copy()
/*     */     {
/* 489 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityUserInfo toData()
/*     */     {
/* 495 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.BackGameActivityUserInfo toBean()
/*     */     {
/* 500 */       return new BackGameActivityUserInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.BackGameActivityUserInfo toDataIf()
/*     */     {
/* 506 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.BackGameActivityUserInfo toBeanIf()
/*     */     {
/* 511 */       return new BackGameActivityUserInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 517 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 521 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 525 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 529 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 533 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 537 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 541 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.BackGameActivityRechargeInfo getRechargeinfo()
/*     */     {
/* 548 */       return this.rechargeinfo;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 554 */       if (!(_o1_ instanceof Data)) return false;
/* 555 */       Data _o_ = (Data)_o1_;
/* 556 */       if (!this.rechargeinfo.equals(_o_.rechargeinfo)) return false;
/* 557 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 563 */       int _h_ = 0;
/* 564 */       _h_ += this.rechargeinfo.hashCode();
/* 565 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 571 */       StringBuilder _sb_ = new StringBuilder();
/* 572 */       _sb_.append("(");
/* 573 */       _sb_.append(this.rechargeinfo);
/* 574 */       _sb_.append(")");
/* 575 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\BackGameActivityUserInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */