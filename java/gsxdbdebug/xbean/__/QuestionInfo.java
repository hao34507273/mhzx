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
/*     */ public final class QuestionInfo extends XBean implements xbean.QuestionInfo
/*     */ {
/*     */   private xbean.EveryDayQuestionAnswerInfo everydayinfo;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.everydayinfo._reset_unsafe_();
/*     */   }
/*     */   
/*     */   QuestionInfo(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.everydayinfo = new EveryDayQuestionAnswerInfo(0, this, "everydayinfo");
/*     */   }
/*     */   
/*     */   public QuestionInfo()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public QuestionInfo(QuestionInfo _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   QuestionInfo(xbean.QuestionInfo _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof QuestionInfo)) { assign((QuestionInfo)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(QuestionInfo _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.everydayinfo = new EveryDayQuestionAnswerInfo(_o_.everydayinfo, this, "everydayinfo");
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  54 */     this.everydayinfo = new EveryDayQuestionAnswerInfo(_o_.everydayinfo, this, "everydayinfo");
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  60 */     _xdb_verify_unsafe_();
/*  61 */     this.everydayinfo.marshal(_os_);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  68 */     _xdb_verify_unsafe_();
/*  69 */     this.everydayinfo.unmarshal(_os_);
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     int _size_ = 0;
/*  78 */     _size_ += CodedOutputStream.computeMessageSize(1, this.everydayinfo);
/*  79 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  88 */       _output_.writeMessage(1, this.everydayinfo);
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
/* 116 */           _input_.readMessage(this.everydayinfo);
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
/*     */   public xbean.QuestionInfo copy()
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/* 145 */     return new QuestionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.QuestionInfo toData()
/*     */   {
/* 151 */     _xdb_verify_unsafe_();
/* 152 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.QuestionInfo toBean()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new QuestionInfo(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.QuestionInfo toDataIf()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.QuestionInfo toBeanIf()
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
/*     */   public xbean.EveryDayQuestionAnswerInfo getEverydayinfo()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return this.everydayinfo;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     QuestionInfo _o_ = null;
/* 194 */     if ((_o1_ instanceof QuestionInfo)) { _o_ = (QuestionInfo)_o1_;
/* 195 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 196 */       return false;
/* 197 */     if (!this.everydayinfo.equals(_o_.everydayinfo)) return false;
/* 198 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     int _h_ = 0;
/* 206 */     _h_ += this.everydayinfo.hashCode();
/* 207 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 213 */     _xdb_verify_unsafe_();
/* 214 */     StringBuilder _sb_ = new StringBuilder();
/* 215 */     _sb_.append("(");
/* 216 */     _sb_.append(this.everydayinfo);
/* 217 */     _sb_.append(")");
/* 218 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 224 */     ListenableBean lb = new ListenableBean();
/* 225 */     lb.add(new xdb.logs.ListenableChanged().setVarName("everydayinfo"));
/* 226 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.QuestionInfo {
/*     */     private Const() {}
/*     */     
/*     */     QuestionInfo nThis() {
/* 233 */       return QuestionInfo.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 239 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QuestionInfo copy()
/*     */     {
/* 245 */       return QuestionInfo.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QuestionInfo toData()
/*     */     {
/* 251 */       return QuestionInfo.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.QuestionInfo toBean()
/*     */     {
/* 256 */       return QuestionInfo.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QuestionInfo toDataIf()
/*     */     {
/* 262 */       return QuestionInfo.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.QuestionInfo toBeanIf()
/*     */     {
/* 267 */       return QuestionInfo.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public xbean.EveryDayQuestionAnswerInfo getEverydayinfo()
/*     */     {
/* 274 */       QuestionInfo.this._xdb_verify_unsafe_();
/* 275 */       return (xbean.EveryDayQuestionAnswerInfo)xdb.Consts.toConst(QuestionInfo.this.everydayinfo);
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 281 */       QuestionInfo.this._xdb_verify_unsafe_();
/* 282 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 288 */       QuestionInfo.this._xdb_verify_unsafe_();
/* 289 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 295 */       return QuestionInfo.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 301 */       return QuestionInfo.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 307 */       QuestionInfo.this._xdb_verify_unsafe_();
/* 308 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 314 */       return QuestionInfo.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 320 */       return QuestionInfo.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 326 */       QuestionInfo.this._xdb_verify_unsafe_();
/* 327 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 333 */       return QuestionInfo.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 339 */       return QuestionInfo.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 345 */       return QuestionInfo.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 351 */       return QuestionInfo.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 357 */       return QuestionInfo.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 363 */       return QuestionInfo.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 369 */       return QuestionInfo.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.QuestionInfo
/*     */   {
/*     */     private xbean.EveryDayQuestionAnswerInfo everydayinfo;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 381 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 386 */       this.everydayinfo = new EveryDayQuestionAnswerInfo.Data();
/*     */     }
/*     */     
/*     */     Data(xbean.QuestionInfo _o1_)
/*     */     {
/* 391 */       if ((_o1_ instanceof QuestionInfo)) { assign((QuestionInfo)_o1_);
/* 392 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 393 */       } else if ((_o1_ instanceof QuestionInfo.Const)) assign(((QuestionInfo.Const)_o1_).nThis()); else {
/* 394 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(QuestionInfo _o_) {
/* 399 */       this.everydayinfo = new EveryDayQuestionAnswerInfo.Data(_o_.everydayinfo);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 404 */       this.everydayinfo = new EveryDayQuestionAnswerInfo.Data(_o_.everydayinfo);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 410 */       this.everydayinfo.marshal(_os_);
/* 411 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 417 */       this.everydayinfo.unmarshal(_os_);
/* 418 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 424 */       int _size_ = 0;
/* 425 */       _size_ += CodedOutputStream.computeMessageSize(1, this.everydayinfo);
/* 426 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 434 */         _output_.writeMessage(1, this.everydayinfo);
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
/* 461 */             _input_.readMessage(this.everydayinfo);
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
/*     */     public xbean.QuestionInfo copy()
/*     */     {
/* 489 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QuestionInfo toData()
/*     */     {
/* 495 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.QuestionInfo toBean()
/*     */     {
/* 500 */       return new QuestionInfo(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QuestionInfo toDataIf()
/*     */     {
/* 506 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.QuestionInfo toBeanIf()
/*     */     {
/* 511 */       return new QuestionInfo(this, null, null);
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
/*     */     public xbean.EveryDayQuestionAnswerInfo getEverydayinfo()
/*     */     {
/* 548 */       return this.everydayinfo;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 554 */       if (!(_o1_ instanceof Data)) return false;
/* 555 */       Data _o_ = (Data)_o1_;
/* 556 */       if (!this.everydayinfo.equals(_o_.everydayinfo)) return false;
/* 557 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 563 */       int _h_ = 0;
/* 564 */       _h_ += this.everydayinfo.hashCode();
/* 565 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 571 */       StringBuilder _sb_ = new StringBuilder();
/* 572 */       _sb_.append("(");
/* 573 */       _sb_.append(this.everydayinfo);
/* 574 */       _sb_.append(")");
/* 575 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\QuestionInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */