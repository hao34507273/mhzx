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
/*     */ public final class XiaoHuiKuaiPaoGlobalInfo extends XBean implements xbean.XiaoHuiKuaiPaoGlobalInfo
/*     */ {
/*     */   private boolean isautodraw;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.isautodraw = false;
/*     */   }
/*     */   
/*     */   XiaoHuiKuaiPaoGlobalInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public XiaoHuiKuaiPaoGlobalInfo()
/*     */   {
/*  28 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public XiaoHuiKuaiPaoGlobalInfo(XiaoHuiKuaiPaoGlobalInfo _o_)
/*     */   {
/*  33 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   XiaoHuiKuaiPaoGlobalInfo(xbean.XiaoHuiKuaiPaoGlobalInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  38 */     super(_xp_, _vn_);
/*  39 */     if ((_o1_ instanceof XiaoHuiKuaiPaoGlobalInfo)) { assign((XiaoHuiKuaiPaoGlobalInfo)_o1_);
/*  40 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  41 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  42 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(XiaoHuiKuaiPaoGlobalInfo _o_) {
/*  47 */     _o_._xdb_verify_unsafe_();
/*  48 */     this.isautodraw = _o_.isautodraw;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  53 */     this.isautodraw = _o_.isautodraw;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  59 */     _xdb_verify_unsafe_();
/*  60 */     _os_.marshal(this.isautodraw);
/*  61 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  67 */     _xdb_verify_unsafe_();
/*  68 */     this.isautodraw = _os_.unmarshal_boolean();
/*  69 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  75 */     _xdb_verify_unsafe_();
/*  76 */     int _size_ = 0;
/*  77 */     _size_ += CodedOutputStream.computeBoolSize(1, this.isautodraw);
/*  78 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  84 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  87 */       _output_.writeBool(1, this.isautodraw);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/*  91 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/*  93 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 102 */       boolean done = false;
/* 103 */       while (!done)
/*     */       {
/* 105 */         int tag = _input_.readTag();
/* 106 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 110 */           done = true;
/* 111 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 115 */           this.isautodraw = _input_.readBool();
/* 116 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 120 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 122 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 131 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 135 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 137 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.XiaoHuiKuaiPaoGlobalInfo copy()
/*     */   {
/* 143 */     _xdb_verify_unsafe_();
/* 144 */     return new XiaoHuiKuaiPaoGlobalInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.XiaoHuiKuaiPaoGlobalInfo toData()
/*     */   {
/* 150 */     _xdb_verify_unsafe_();
/* 151 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.XiaoHuiKuaiPaoGlobalInfo toBean()
/*     */   {
/* 156 */     _xdb_verify_unsafe_();
/* 157 */     return new XiaoHuiKuaiPaoGlobalInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.XiaoHuiKuaiPaoGlobalInfo toDataIf()
/*     */   {
/* 163 */     _xdb_verify_unsafe_();
/* 164 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.XiaoHuiKuaiPaoGlobalInfo toBeanIf()
/*     */   {
/* 169 */     _xdb_verify_unsafe_();
/* 170 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public Bean toConst()
/*     */   {
/* 176 */     _xdb_verify_unsafe_();
/* 177 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getIsautodraw()
/*     */   {
/* 184 */     _xdb_verify_unsafe_();
/* 185 */     return this.isautodraw;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setIsautodraw(boolean _v_)
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     xdb.Logs.logIf(new LogKey(this, "isautodraw")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 197 */         new xdb.logs.LogObject(this, Boolean.valueOf(XiaoHuiKuaiPaoGlobalInfo.this.isautodraw))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 201 */             XiaoHuiKuaiPaoGlobalInfo.this.isautodraw = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 205 */     });
/* 206 */     this.isautodraw = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 212 */     _xdb_verify_unsafe_();
/* 213 */     XiaoHuiKuaiPaoGlobalInfo _o_ = null;
/* 214 */     if ((_o1_ instanceof XiaoHuiKuaiPaoGlobalInfo)) { _o_ = (XiaoHuiKuaiPaoGlobalInfo)_o1_;
/* 215 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 216 */       return false;
/* 217 */     if (this.isautodraw != _o_.isautodraw) return false;
/* 218 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     int _h_ = 0;
/* 226 */     _h_ += (this.isautodraw ? 1231 : 1237);
/* 227 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 233 */     _xdb_verify_unsafe_();
/* 234 */     StringBuilder _sb_ = new StringBuilder();
/* 235 */     _sb_.append("(");
/* 236 */     _sb_.append(this.isautodraw);
/* 237 */     _sb_.append(")");
/* 238 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 244 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 245 */     lb.add(new xdb.logs.ListenableChanged().setVarName("isautodraw"));
/* 246 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.XiaoHuiKuaiPaoGlobalInfo {
/*     */     private Const() {}
/*     */     
/*     */     XiaoHuiKuaiPaoGlobalInfo nThis() {
/* 253 */       return XiaoHuiKuaiPaoGlobalInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 259 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XiaoHuiKuaiPaoGlobalInfo copy()
/*     */     {
/* 265 */       return XiaoHuiKuaiPaoGlobalInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XiaoHuiKuaiPaoGlobalInfo toData()
/*     */     {
/* 271 */       return XiaoHuiKuaiPaoGlobalInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.XiaoHuiKuaiPaoGlobalInfo toBean()
/*     */     {
/* 276 */       return XiaoHuiKuaiPaoGlobalInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XiaoHuiKuaiPaoGlobalInfo toDataIf()
/*     */     {
/* 282 */       return XiaoHuiKuaiPaoGlobalInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.XiaoHuiKuaiPaoGlobalInfo toBeanIf()
/*     */     {
/* 287 */       return XiaoHuiKuaiPaoGlobalInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsautodraw()
/*     */     {
/* 294 */       XiaoHuiKuaiPaoGlobalInfo.this._xdb_verify_unsafe_();
/* 295 */       return XiaoHuiKuaiPaoGlobalInfo.this.isautodraw;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsautodraw(boolean _v_)
/*     */     {
/* 302 */       XiaoHuiKuaiPaoGlobalInfo.this._xdb_verify_unsafe_();
/* 303 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 309 */       XiaoHuiKuaiPaoGlobalInfo.this._xdb_verify_unsafe_();
/* 310 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 316 */       XiaoHuiKuaiPaoGlobalInfo.this._xdb_verify_unsafe_();
/* 317 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 323 */       return XiaoHuiKuaiPaoGlobalInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 329 */       return XiaoHuiKuaiPaoGlobalInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 335 */       XiaoHuiKuaiPaoGlobalInfo.this._xdb_verify_unsafe_();
/* 336 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 342 */       return XiaoHuiKuaiPaoGlobalInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 348 */       return XiaoHuiKuaiPaoGlobalInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 354 */       XiaoHuiKuaiPaoGlobalInfo.this._xdb_verify_unsafe_();
/* 355 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 361 */       return XiaoHuiKuaiPaoGlobalInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 367 */       return XiaoHuiKuaiPaoGlobalInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 373 */       return XiaoHuiKuaiPaoGlobalInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 379 */       return XiaoHuiKuaiPaoGlobalInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 385 */       return XiaoHuiKuaiPaoGlobalInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 391 */       return XiaoHuiKuaiPaoGlobalInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 397 */       return XiaoHuiKuaiPaoGlobalInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.XiaoHuiKuaiPaoGlobalInfo
/*     */   {
/*     */     private boolean isautodraw;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 409 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Data() {}
/*     */     
/*     */ 
/*     */     Data(xbean.XiaoHuiKuaiPaoGlobalInfo _o1_)
/*     */     {
/* 418 */       if ((_o1_ instanceof XiaoHuiKuaiPaoGlobalInfo)) { assign((XiaoHuiKuaiPaoGlobalInfo)_o1_);
/* 419 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 420 */       } else if ((_o1_ instanceof XiaoHuiKuaiPaoGlobalInfo.Const)) assign(((XiaoHuiKuaiPaoGlobalInfo.Const)_o1_).nThis()); else {
/* 421 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(XiaoHuiKuaiPaoGlobalInfo _o_) {
/* 426 */       this.isautodraw = _o_.isautodraw;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 431 */       this.isautodraw = _o_.isautodraw;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 437 */       _os_.marshal(this.isautodraw);
/* 438 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 444 */       this.isautodraw = _os_.unmarshal_boolean();
/* 445 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 451 */       int _size_ = 0;
/* 452 */       _size_ += CodedOutputStream.computeBoolSize(1, this.isautodraw);
/* 453 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 461 */         _output_.writeBool(1, this.isautodraw);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 465 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 467 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 475 */         boolean done = false;
/* 476 */         while (!done)
/*     */         {
/* 478 */           int tag = _input_.readTag();
/* 479 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 483 */             done = true;
/* 484 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 488 */             this.isautodraw = _input_.readBool();
/* 489 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 493 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 495 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 504 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 508 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 510 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XiaoHuiKuaiPaoGlobalInfo copy()
/*     */     {
/* 516 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XiaoHuiKuaiPaoGlobalInfo toData()
/*     */     {
/* 522 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.XiaoHuiKuaiPaoGlobalInfo toBean()
/*     */     {
/* 527 */       return new XiaoHuiKuaiPaoGlobalInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.XiaoHuiKuaiPaoGlobalInfo toDataIf()
/*     */     {
/* 533 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.XiaoHuiKuaiPaoGlobalInfo toBeanIf()
/*     */     {
/* 538 */       return new XiaoHuiKuaiPaoGlobalInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 544 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean xdbParent() {
/* 548 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 552 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 556 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Bean toConst() {
/* 560 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 564 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 568 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getIsautodraw()
/*     */     {
/* 575 */       return this.isautodraw;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setIsautodraw(boolean _v_)
/*     */     {
/* 582 */       this.isautodraw = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 588 */       if (!(_o1_ instanceof Data)) return false;
/* 589 */       Data _o_ = (Data)_o1_;
/* 590 */       if (this.isautodraw != _o_.isautodraw) return false;
/* 591 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 597 */       int _h_ = 0;
/* 598 */       _h_ += (this.isautodraw ? 1231 : 1237);
/* 599 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 605 */       StringBuilder _sb_ = new StringBuilder();
/* 606 */       _sb_.append("(");
/* 607 */       _sb_.append(this.isautodraw);
/* 608 */       _sb_.append(")");
/* 609 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\XiaoHuiKuaiPaoGlobalInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */