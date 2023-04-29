/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ import xdb.logs.ListenableChanged;
/*     */ 
/*     */ public final class QuestionVoiceBean extends XBean implements xbean.QuestionVoiceBean
/*     */ {
/*     */   private int now_question_id;
/*     */   private ArrayList<Integer> now_optional_order;
/*     */   private int last_question_id;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  22 */     this.now_question_id = 0;
/*  23 */     this.now_optional_order.clear();
/*  24 */     this.last_question_id = 0;
/*     */   }
/*     */   
/*     */   QuestionVoiceBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  29 */     super(_xp_, _vn_);
/*  30 */     this.now_optional_order = new ArrayList();
/*     */   }
/*     */   
/*     */   public QuestionVoiceBean()
/*     */   {
/*  35 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public QuestionVoiceBean(QuestionVoiceBean _o_)
/*     */   {
/*  40 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   QuestionVoiceBean(xbean.QuestionVoiceBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  45 */     super(_xp_, _vn_);
/*  46 */     if ((_o1_ instanceof QuestionVoiceBean)) { assign((QuestionVoiceBean)_o1_);
/*  47 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  48 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  49 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(QuestionVoiceBean _o_) {
/*  54 */     _o_._xdb_verify_unsafe_();
/*  55 */     this.now_question_id = _o_.now_question_id;
/*  56 */     this.now_optional_order = new ArrayList();
/*  57 */     this.now_optional_order.addAll(_o_.now_optional_order);
/*  58 */     this.last_question_id = _o_.last_question_id;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  63 */     this.now_question_id = _o_.now_question_id;
/*  64 */     this.now_optional_order = new ArrayList();
/*  65 */     this.now_optional_order.addAll(_o_.now_optional_order);
/*  66 */     this.last_question_id = _o_.last_question_id;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  72 */     _xdb_verify_unsafe_();
/*  73 */     _os_.marshal(this.now_question_id);
/*  74 */     _os_.compact_uint32(this.now_optional_order.size());
/*  75 */     for (Integer _v_ : this.now_optional_order)
/*     */     {
/*  77 */       _os_.marshal(_v_.intValue());
/*     */     }
/*  79 */     _os_.marshal(this.last_question_id);
/*  80 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  86 */     _xdb_verify_unsafe_();
/*  87 */     this.now_question_id = _os_.unmarshal_int();
/*  88 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  90 */       int _v_ = 0;
/*  91 */       _v_ = _os_.unmarshal_int();
/*  92 */       this.now_optional_order.add(Integer.valueOf(_v_));
/*     */     }
/*  94 */     this.last_question_id = _os_.unmarshal_int();
/*  95 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/* 101 */     _xdb_verify_unsafe_();
/* 102 */     int _size_ = 0;
/* 103 */     _size_ += CodedOutputStream.computeInt32Size(1, this.now_question_id);
/* 104 */     for (Integer _v_ : this.now_optional_order)
/*     */     {
/* 106 */       _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */     }
/* 108 */     _size_ += CodedOutputStream.computeInt32Size(3, this.last_question_id);
/* 109 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 115 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 118 */       _output_.writeInt32(1, this.now_question_id);
/* 119 */       for (Integer _v_ : this.now_optional_order)
/*     */       {
/* 121 */         _output_.writeInt32(2, _v_.intValue());
/*     */       }
/* 123 */       _output_.writeInt32(3, this.last_question_id);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 127 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 129 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 135 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 138 */       boolean done = false;
/* 139 */       while (!done)
/*     */       {
/* 141 */         int tag = _input_.readTag();
/* 142 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 146 */           done = true;
/* 147 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 151 */           this.now_question_id = _input_.readInt32();
/* 152 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 156 */           int _v_ = 0;
/* 157 */           _v_ = _input_.readInt32();
/* 158 */           this.now_optional_order.add(Integer.valueOf(_v_));
/* 159 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 163 */           this.last_question_id = _input_.readInt32();
/* 164 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 168 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 170 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 179 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 183 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 185 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.QuestionVoiceBean copy()
/*     */   {
/* 191 */     _xdb_verify_unsafe_();
/* 192 */     return new QuestionVoiceBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.QuestionVoiceBean toData()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.QuestionVoiceBean toBean()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return new QuestionVoiceBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.QuestionVoiceBean toDataIf()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/* 212 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.QuestionVoiceBean toBeanIf()
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 224 */     _xdb_verify_unsafe_();
/* 225 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getNow_question_id()
/*     */   {
/* 232 */     _xdb_verify_unsafe_();
/* 233 */     return this.now_question_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Integer> getNow_optional_order()
/*     */   {
/* 240 */     _xdb_verify_unsafe_();
/* 241 */     return xdb.Logs.logList(new LogKey(this, "now_optional_order"), this.now_optional_order);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Integer> getNow_optional_orderAsData()
/*     */   {
/* 247 */     _xdb_verify_unsafe_();
/*     */     
/* 249 */     QuestionVoiceBean _o_ = this;
/* 250 */     List<Integer> now_optional_order = new ArrayList();
/* 251 */     now_optional_order.addAll(_o_.now_optional_order);
/* 252 */     return now_optional_order;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getLast_question_id()
/*     */   {
/* 259 */     _xdb_verify_unsafe_();
/* 260 */     return this.last_question_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setNow_question_id(int _v_)
/*     */   {
/* 267 */     _xdb_verify_unsafe_();
/* 268 */     xdb.Logs.logIf(new LogKey(this, "now_question_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 272 */         new xdb.logs.LogInt(this, QuestionVoiceBean.this.now_question_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 276 */             QuestionVoiceBean.this.now_question_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 280 */     });
/* 281 */     this.now_question_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setLast_question_id(int _v_)
/*     */   {
/* 288 */     _xdb_verify_unsafe_();
/* 289 */     xdb.Logs.logIf(new LogKey(this, "last_question_id")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 293 */         new xdb.logs.LogInt(this, QuestionVoiceBean.this.last_question_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 297 */             QuestionVoiceBean.this.last_question_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 301 */     });
/* 302 */     this.last_question_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 308 */     _xdb_verify_unsafe_();
/* 309 */     QuestionVoiceBean _o_ = null;
/* 310 */     if ((_o1_ instanceof QuestionVoiceBean)) { _o_ = (QuestionVoiceBean)_o1_;
/* 311 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 312 */       return false;
/* 313 */     if (this.now_question_id != _o_.now_question_id) return false;
/* 314 */     if (!this.now_optional_order.equals(_o_.now_optional_order)) return false;
/* 315 */     if (this.last_question_id != _o_.last_question_id) return false;
/* 316 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 322 */     _xdb_verify_unsafe_();
/* 323 */     int _h_ = 0;
/* 324 */     _h_ += this.now_question_id;
/* 325 */     _h_ += this.now_optional_order.hashCode();
/* 326 */     _h_ += this.last_question_id;
/* 327 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 333 */     _xdb_verify_unsafe_();
/* 334 */     StringBuilder _sb_ = new StringBuilder();
/* 335 */     _sb_.append("(");
/* 336 */     _sb_.append(this.now_question_id);
/* 337 */     _sb_.append(",");
/* 338 */     _sb_.append(this.now_optional_order);
/* 339 */     _sb_.append(",");
/* 340 */     _sb_.append(this.last_question_id);
/* 341 */     _sb_.append(")");
/* 342 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 348 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 349 */     lb.add(new ListenableChanged().setVarName("now_question_id"));
/* 350 */     lb.add(new ListenableChanged().setVarName("now_optional_order"));
/* 351 */     lb.add(new ListenableChanged().setVarName("last_question_id"));
/* 352 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.QuestionVoiceBean {
/*     */     private Const() {}
/*     */     
/*     */     QuestionVoiceBean nThis() {
/* 359 */       return QuestionVoiceBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 365 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QuestionVoiceBean copy()
/*     */     {
/* 371 */       return QuestionVoiceBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QuestionVoiceBean toData()
/*     */     {
/* 377 */       return QuestionVoiceBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.QuestionVoiceBean toBean()
/*     */     {
/* 382 */       return QuestionVoiceBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QuestionVoiceBean toDataIf()
/*     */     {
/* 388 */       return QuestionVoiceBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.QuestionVoiceBean toBeanIf()
/*     */     {
/* 393 */       return QuestionVoiceBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNow_question_id()
/*     */     {
/* 400 */       QuestionVoiceBean.this._xdb_verify_unsafe_();
/* 401 */       return QuestionVoiceBean.this.now_question_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getNow_optional_order()
/*     */     {
/* 408 */       QuestionVoiceBean.this._xdb_verify_unsafe_();
/* 409 */       return xdb.Consts.constList(QuestionVoiceBean.this.now_optional_order);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Integer> getNow_optional_orderAsData()
/*     */     {
/* 415 */       QuestionVoiceBean.this._xdb_verify_unsafe_();
/*     */       
/* 417 */       QuestionVoiceBean _o_ = QuestionVoiceBean.this;
/* 418 */       List<Integer> now_optional_order = new ArrayList();
/* 419 */       now_optional_order.addAll(_o_.now_optional_order);
/* 420 */       return now_optional_order;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLast_question_id()
/*     */     {
/* 427 */       QuestionVoiceBean.this._xdb_verify_unsafe_();
/* 428 */       return QuestionVoiceBean.this.last_question_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNow_question_id(int _v_)
/*     */     {
/* 435 */       QuestionVoiceBean.this._xdb_verify_unsafe_();
/* 436 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_question_id(int _v_)
/*     */     {
/* 443 */       QuestionVoiceBean.this._xdb_verify_unsafe_();
/* 444 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 450 */       QuestionVoiceBean.this._xdb_verify_unsafe_();
/* 451 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 457 */       QuestionVoiceBean.this._xdb_verify_unsafe_();
/* 458 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 464 */       return QuestionVoiceBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 470 */       return QuestionVoiceBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 476 */       QuestionVoiceBean.this._xdb_verify_unsafe_();
/* 477 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 483 */       return QuestionVoiceBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 489 */       return QuestionVoiceBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 495 */       QuestionVoiceBean.this._xdb_verify_unsafe_();
/* 496 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 502 */       return QuestionVoiceBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 508 */       return QuestionVoiceBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 514 */       return QuestionVoiceBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 520 */       return QuestionVoiceBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 526 */       return QuestionVoiceBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 532 */       return QuestionVoiceBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 538 */       return QuestionVoiceBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.QuestionVoiceBean
/*     */   {
/*     */     private int now_question_id;
/*     */     
/*     */     private ArrayList<Integer> now_optional_order;
/*     */     
/*     */     private int last_question_id;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 554 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 559 */       this.now_optional_order = new ArrayList();
/*     */     }
/*     */     
/*     */     Data(xbean.QuestionVoiceBean _o1_)
/*     */     {
/* 564 */       if ((_o1_ instanceof QuestionVoiceBean)) { assign((QuestionVoiceBean)_o1_);
/* 565 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 566 */       } else if ((_o1_ instanceof QuestionVoiceBean.Const)) assign(((QuestionVoiceBean.Const)_o1_).nThis()); else {
/* 567 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(QuestionVoiceBean _o_) {
/* 572 */       this.now_question_id = _o_.now_question_id;
/* 573 */       this.now_optional_order = new ArrayList();
/* 574 */       this.now_optional_order.addAll(_o_.now_optional_order);
/* 575 */       this.last_question_id = _o_.last_question_id;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 580 */       this.now_question_id = _o_.now_question_id;
/* 581 */       this.now_optional_order = new ArrayList();
/* 582 */       this.now_optional_order.addAll(_o_.now_optional_order);
/* 583 */       this.last_question_id = _o_.last_question_id;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 589 */       _os_.marshal(this.now_question_id);
/* 590 */       _os_.compact_uint32(this.now_optional_order.size());
/* 591 */       for (Integer _v_ : this.now_optional_order)
/*     */       {
/* 593 */         _os_.marshal(_v_.intValue());
/*     */       }
/* 595 */       _os_.marshal(this.last_question_id);
/* 596 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 602 */       this.now_question_id = _os_.unmarshal_int();
/* 603 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 605 */         int _v_ = 0;
/* 606 */         _v_ = _os_.unmarshal_int();
/* 607 */         this.now_optional_order.add(Integer.valueOf(_v_));
/*     */       }
/* 609 */       this.last_question_id = _os_.unmarshal_int();
/* 610 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 616 */       int _size_ = 0;
/* 617 */       _size_ += CodedOutputStream.computeInt32Size(1, this.now_question_id);
/* 618 */       for (Integer _v_ : this.now_optional_order)
/*     */       {
/* 620 */         _size_ += CodedOutputStream.computeInt32Size(2, _v_.intValue());
/*     */       }
/* 622 */       _size_ += CodedOutputStream.computeInt32Size(3, this.last_question_id);
/* 623 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 631 */         _output_.writeInt32(1, this.now_question_id);
/* 632 */         for (Integer _v_ : this.now_optional_order)
/*     */         {
/* 634 */           _output_.writeInt32(2, _v_.intValue());
/*     */         }
/* 636 */         _output_.writeInt32(3, this.last_question_id);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 640 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 642 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 650 */         boolean done = false;
/* 651 */         while (!done)
/*     */         {
/* 653 */           int tag = _input_.readTag();
/* 654 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 658 */             done = true;
/* 659 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 663 */             this.now_question_id = _input_.readInt32();
/* 664 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 668 */             int _v_ = 0;
/* 669 */             _v_ = _input_.readInt32();
/* 670 */             this.now_optional_order.add(Integer.valueOf(_v_));
/* 671 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 675 */             this.last_question_id = _input_.readInt32();
/* 676 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 680 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 682 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 691 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 695 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 697 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QuestionVoiceBean copy()
/*     */     {
/* 703 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QuestionVoiceBean toData()
/*     */     {
/* 709 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.QuestionVoiceBean toBean()
/*     */     {
/* 714 */       return new QuestionVoiceBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.QuestionVoiceBean toDataIf()
/*     */     {
/* 720 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.QuestionVoiceBean toBeanIf()
/*     */     {
/* 725 */       return new QuestionVoiceBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 731 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 735 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 739 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 743 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 747 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 751 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 755 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getNow_question_id()
/*     */     {
/* 762 */       return this.now_question_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getNow_optional_order()
/*     */     {
/* 769 */       return this.now_optional_order;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Integer> getNow_optional_orderAsData()
/*     */     {
/* 776 */       return this.now_optional_order;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getLast_question_id()
/*     */     {
/* 783 */       return this.last_question_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setNow_question_id(int _v_)
/*     */     {
/* 790 */       this.now_question_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setLast_question_id(int _v_)
/*     */     {
/* 797 */       this.last_question_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 803 */       if (!(_o1_ instanceof Data)) return false;
/* 804 */       Data _o_ = (Data)_o1_;
/* 805 */       if (this.now_question_id != _o_.now_question_id) return false;
/* 806 */       if (!this.now_optional_order.equals(_o_.now_optional_order)) return false;
/* 807 */       if (this.last_question_id != _o_.last_question_id) return false;
/* 808 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 814 */       int _h_ = 0;
/* 815 */       _h_ += this.now_question_id;
/* 816 */       _h_ += this.now_optional_order.hashCode();
/* 817 */       _h_ += this.last_question_id;
/* 818 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 824 */       StringBuilder _sb_ = new StringBuilder();
/* 825 */       _sb_.append("(");
/* 826 */       _sb_.append(this.now_question_id);
/* 827 */       _sb_.append(",");
/* 828 */       _sb_.append(this.now_optional_order);
/* 829 */       _sb_.append(",");
/* 830 */       _sb_.append(this.last_question_id);
/* 831 */       _sb_.append(")");
/* 832 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\QuestionVoiceBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */