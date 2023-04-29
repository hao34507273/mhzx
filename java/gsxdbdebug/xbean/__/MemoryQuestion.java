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
/*     */ public final class MemoryQuestion extends XBean implements xbean.MemoryQuestion
/*     */ {
/*     */   private int question_id;
/*     */   private boolean answer_result;
/*     */   private long answer_time;
/*     */   private int answer_id;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  24 */     this.question_id = 0;
/*  25 */     this.answer_result = false;
/*  26 */     this.answer_time = 0L;
/*  27 */     this.answer_id = 0;
/*     */   }
/*     */   
/*     */   MemoryQuestion(int __, XBean _xp_, String _vn_)
/*     */   {
/*  32 */     super(_xp_, _vn_);
/*     */   }
/*     */   
/*     */   public MemoryQuestion()
/*     */   {
/*  37 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public MemoryQuestion(MemoryQuestion _o_)
/*     */   {
/*  42 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   MemoryQuestion(xbean.MemoryQuestion _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  47 */     super(_xp_, _vn_);
/*  48 */     if ((_o1_ instanceof MemoryQuestion)) { assign((MemoryQuestion)_o1_);
/*  49 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  50 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  51 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(MemoryQuestion _o_) {
/*  56 */     _o_._xdb_verify_unsafe_();
/*  57 */     this.question_id = _o_.question_id;
/*  58 */     this.answer_result = _o_.answer_result;
/*  59 */     this.answer_time = _o_.answer_time;
/*  60 */     this.answer_id = _o_.answer_id;
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  65 */     this.question_id = _o_.question_id;
/*  66 */     this.answer_result = _o_.answer_result;
/*  67 */     this.answer_time = _o_.answer_time;
/*  68 */     this.answer_id = _o_.answer_id;
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     _os_.marshal(this.question_id);
/*  76 */     _os_.marshal(this.answer_result);
/*  77 */     _os_.marshal(this.answer_time);
/*  78 */     _os_.marshal(this.answer_id);
/*  79 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*  86 */     this.question_id = _os_.unmarshal_int();
/*  87 */     this.answer_result = _os_.unmarshal_boolean();
/*  88 */     this.answer_time = _os_.unmarshal_long();
/*  89 */     this.answer_id = _os_.unmarshal_int();
/*  90 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  96 */     _xdb_verify_unsafe_();
/*  97 */     int _size_ = 0;
/*  98 */     _size_ += CodedOutputStream.computeInt32Size(1, this.question_id);
/*  99 */     _size_ += CodedOutputStream.computeBoolSize(2, this.answer_result);
/* 100 */     _size_ += CodedOutputStream.computeInt64Size(3, this.answer_time);
/* 101 */     _size_ += CodedOutputStream.computeInt32Size(4, this.answer_id);
/* 102 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 108 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 111 */       _output_.writeInt32(1, this.question_id);
/* 112 */       _output_.writeBool(2, this.answer_result);
/* 113 */       _output_.writeInt64(3, this.answer_time);
/* 114 */       _output_.writeInt32(4, this.answer_id);
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
/* 142 */           this.question_id = _input_.readInt32();
/* 143 */           break;
/*     */         
/*     */ 
/*     */         case 16: 
/* 147 */           this.answer_result = _input_.readBool();
/* 148 */           break;
/*     */         
/*     */ 
/*     */         case 24: 
/* 152 */           this.answer_time = _input_.readInt64();
/* 153 */           break;
/*     */         
/*     */ 
/*     */         case 32: 
/* 157 */           this.answer_id = _input_.readInt32();
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
/*     */   public xbean.MemoryQuestion copy()
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/* 186 */     return new MemoryQuestion(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MemoryQuestion toData()
/*     */   {
/* 192 */     _xdb_verify_unsafe_();
/* 193 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MemoryQuestion toBean()
/*     */   {
/* 198 */     _xdb_verify_unsafe_();
/* 199 */     return new MemoryQuestion(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.MemoryQuestion toDataIf()
/*     */   {
/* 205 */     _xdb_verify_unsafe_();
/* 206 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.MemoryQuestion toBeanIf()
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
/*     */   public int getQuestion_id()
/*     */   {
/* 226 */     _xdb_verify_unsafe_();
/* 227 */     return this.question_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean getAnswer_result()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     return this.answer_result;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public long getAnswer_time()
/*     */   {
/* 242 */     _xdb_verify_unsafe_();
/* 243 */     return this.answer_time;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public int getAnswer_id()
/*     */   {
/* 250 */     _xdb_verify_unsafe_();
/* 251 */     return this.answer_id;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setQuestion_id(int _v_)
/*     */   {
/* 258 */     _xdb_verify_unsafe_();
/* 259 */     xdb.Logs.logIf(new LogKey(this, "question_id")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 263 */         new xdb.logs.LogInt(this, MemoryQuestion.this.question_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 267 */             MemoryQuestion.this.question_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 271 */     });
/* 272 */     this.question_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAnswer_result(boolean _v_)
/*     */   {
/* 279 */     _xdb_verify_unsafe_();
/* 280 */     xdb.Logs.logIf(new LogKey(this, "answer_result")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 284 */         new xdb.logs.LogObject(this, Boolean.valueOf(MemoryQuestion.this.answer_result))
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 288 */             MemoryQuestion.this.answer_result = ((Boolean)this._xdb_saved).booleanValue();
/*     */           }
/*     */         };
/*     */       }
/* 292 */     });
/* 293 */     this.answer_result = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAnswer_time(long _v_)
/*     */   {
/* 300 */     _xdb_verify_unsafe_();
/* 301 */     xdb.Logs.logIf(new LogKey(this, "answer_time")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 305 */         new xdb.logs.LogLong(this, MemoryQuestion.this.answer_time)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 309 */             MemoryQuestion.this.answer_time = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 313 */     });
/* 314 */     this.answer_time = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setAnswer_id(int _v_)
/*     */   {
/* 321 */     _xdb_verify_unsafe_();
/* 322 */     xdb.Logs.logIf(new LogKey(this, "answer_id")
/*     */     {
/*     */       protected Log create()
/*     */       {
/* 326 */         new xdb.logs.LogInt(this, MemoryQuestion.this.answer_id)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 330 */             MemoryQuestion.this.answer_id = this._xdb_saved;
/*     */           }
/*     */         };
/*     */       }
/* 334 */     });
/* 335 */     this.answer_id = _v_;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 341 */     _xdb_verify_unsafe_();
/* 342 */     MemoryQuestion _o_ = null;
/* 343 */     if ((_o1_ instanceof MemoryQuestion)) { _o_ = (MemoryQuestion)_o1_;
/* 344 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 345 */       return false;
/* 346 */     if (this.question_id != _o_.question_id) return false;
/* 347 */     if (this.answer_result != _o_.answer_result) return false;
/* 348 */     if (this.answer_time != _o_.answer_time) return false;
/* 349 */     if (this.answer_id != _o_.answer_id) return false;
/* 350 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 356 */     _xdb_verify_unsafe_();
/* 357 */     int _h_ = 0;
/* 358 */     _h_ += this.question_id;
/* 359 */     _h_ += (this.answer_result ? 1231 : 1237);
/* 360 */     _h_ = (int)(_h_ + this.answer_time);
/* 361 */     _h_ += this.answer_id;
/* 362 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 368 */     _xdb_verify_unsafe_();
/* 369 */     StringBuilder _sb_ = new StringBuilder();
/* 370 */     _sb_.append("(");
/* 371 */     _sb_.append(this.question_id);
/* 372 */     _sb_.append(",");
/* 373 */     _sb_.append(this.answer_result);
/* 374 */     _sb_.append(",");
/* 375 */     _sb_.append(this.answer_time);
/* 376 */     _sb_.append(",");
/* 377 */     _sb_.append(this.answer_id);
/* 378 */     _sb_.append(")");
/* 379 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 385 */     ListenableBean lb = new ListenableBean();
/* 386 */     lb.add(new ListenableChanged().setVarName("question_id"));
/* 387 */     lb.add(new ListenableChanged().setVarName("answer_result"));
/* 388 */     lb.add(new ListenableChanged().setVarName("answer_time"));
/* 389 */     lb.add(new ListenableChanged().setVarName("answer_id"));
/* 390 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.MemoryQuestion {
/*     */     private Const() {}
/*     */     
/*     */     MemoryQuestion nThis() {
/* 397 */       return MemoryQuestion.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 403 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MemoryQuestion copy()
/*     */     {
/* 409 */       return MemoryQuestion.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MemoryQuestion toData()
/*     */     {
/* 415 */       return MemoryQuestion.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.MemoryQuestion toBean()
/*     */     {
/* 420 */       return MemoryQuestion.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MemoryQuestion toDataIf()
/*     */     {
/* 426 */       return MemoryQuestion.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.MemoryQuestion toBeanIf()
/*     */     {
/* 431 */       return MemoryQuestion.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getQuestion_id()
/*     */     {
/* 438 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 439 */       return MemoryQuestion.this.question_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAnswer_result()
/*     */     {
/* 446 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 447 */       return MemoryQuestion.this.answer_result;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAnswer_time()
/*     */     {
/* 454 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 455 */       return MemoryQuestion.this.answer_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAnswer_id()
/*     */     {
/* 462 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 463 */       return MemoryQuestion.this.answer_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setQuestion_id(int _v_)
/*     */     {
/* 470 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 471 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnswer_result(boolean _v_)
/*     */     {
/* 478 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 479 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnswer_time(long _v_)
/*     */     {
/* 486 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 487 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnswer_id(int _v_)
/*     */     {
/* 494 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 495 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean toConst()
/*     */     {
/* 501 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 502 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 508 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 509 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 515 */       return MemoryQuestion.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 521 */       return MemoryQuestion.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 527 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 528 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 534 */       return MemoryQuestion.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 540 */       return MemoryQuestion.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 546 */       MemoryQuestion.this._xdb_verify_unsafe_();
/* 547 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public Bean xdbParent()
/*     */     {
/* 553 */       return MemoryQuestion.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 559 */       return MemoryQuestion.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 565 */       return MemoryQuestion.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 571 */       return MemoryQuestion.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 577 */       return MemoryQuestion.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 583 */       return MemoryQuestion.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 589 */       return MemoryQuestion.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.MemoryQuestion
/*     */   {
/*     */     private int question_id;
/*     */     
/*     */     private boolean answer_result;
/*     */     
/*     */     private long answer_time;
/*     */     
/*     */     private int answer_id;
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
/*     */     Data(xbean.MemoryQuestion _o1_)
/*     */     {
/* 616 */       if ((_o1_ instanceof MemoryQuestion)) { assign((MemoryQuestion)_o1_);
/* 617 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 618 */       } else if ((_o1_ instanceof MemoryQuestion.Const)) assign(((MemoryQuestion.Const)_o1_).nThis()); else {
/* 619 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(MemoryQuestion _o_) {
/* 624 */       this.question_id = _o_.question_id;
/* 625 */       this.answer_result = _o_.answer_result;
/* 626 */       this.answer_time = _o_.answer_time;
/* 627 */       this.answer_id = _o_.answer_id;
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 632 */       this.question_id = _o_.question_id;
/* 633 */       this.answer_result = _o_.answer_result;
/* 634 */       this.answer_time = _o_.answer_time;
/* 635 */       this.answer_id = _o_.answer_id;
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 641 */       _os_.marshal(this.question_id);
/* 642 */       _os_.marshal(this.answer_result);
/* 643 */       _os_.marshal(this.answer_time);
/* 644 */       _os_.marshal(this.answer_id);
/* 645 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 651 */       this.question_id = _os_.unmarshal_int();
/* 652 */       this.answer_result = _os_.unmarshal_boolean();
/* 653 */       this.answer_time = _os_.unmarshal_long();
/* 654 */       this.answer_id = _os_.unmarshal_int();
/* 655 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 661 */       int _size_ = 0;
/* 662 */       _size_ += CodedOutputStream.computeInt32Size(1, this.question_id);
/* 663 */       _size_ += CodedOutputStream.computeBoolSize(2, this.answer_result);
/* 664 */       _size_ += CodedOutputStream.computeInt64Size(3, this.answer_time);
/* 665 */       _size_ += CodedOutputStream.computeInt32Size(4, this.answer_id);
/* 666 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 674 */         _output_.writeInt32(1, this.question_id);
/* 675 */         _output_.writeBool(2, this.answer_result);
/* 676 */         _output_.writeInt64(3, this.answer_time);
/* 677 */         _output_.writeInt32(4, this.answer_id);
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
/* 704 */             this.question_id = _input_.readInt32();
/* 705 */             break;
/*     */           
/*     */ 
/*     */           case 16: 
/* 709 */             this.answer_result = _input_.readBool();
/* 710 */             break;
/*     */           
/*     */ 
/*     */           case 24: 
/* 714 */             this.answer_time = _input_.readInt64();
/* 715 */             break;
/*     */           
/*     */ 
/*     */           case 32: 
/* 719 */             this.answer_id = _input_.readInt32();
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
/*     */     public xbean.MemoryQuestion copy()
/*     */     {
/* 747 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MemoryQuestion toData()
/*     */     {
/* 753 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.MemoryQuestion toBean()
/*     */     {
/* 758 */       return new MemoryQuestion(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.MemoryQuestion toDataIf()
/*     */     {
/* 764 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.MemoryQuestion toBeanIf()
/*     */     {
/* 769 */       return new MemoryQuestion(this, null, null);
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
/*     */     public int getQuestion_id()
/*     */     {
/* 806 */       return this.question_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean getAnswer_result()
/*     */     {
/* 813 */       return this.answer_result;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public long getAnswer_time()
/*     */     {
/* 820 */       return this.answer_time;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public int getAnswer_id()
/*     */     {
/* 827 */       return this.answer_id;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setQuestion_id(int _v_)
/*     */     {
/* 834 */       this.question_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnswer_result(boolean _v_)
/*     */     {
/* 841 */       this.answer_result = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnswer_time(long _v_)
/*     */     {
/* 848 */       this.answer_time = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setAnswer_id(int _v_)
/*     */     {
/* 855 */       this.answer_id = _v_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 861 */       if (!(_o1_ instanceof Data)) return false;
/* 862 */       Data _o_ = (Data)_o1_;
/* 863 */       if (this.question_id != _o_.question_id) return false;
/* 864 */       if (this.answer_result != _o_.answer_result) return false;
/* 865 */       if (this.answer_time != _o_.answer_time) return false;
/* 866 */       if (this.answer_id != _o_.answer_id) return false;
/* 867 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 873 */       int _h_ = 0;
/* 874 */       _h_ += this.question_id;
/* 875 */       _h_ += (this.answer_result ? 1231 : 1237);
/* 876 */       _h_ = (int)(_h_ + this.answer_time);
/* 877 */       _h_ += this.answer_id;
/* 878 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 884 */       StringBuilder _sb_ = new StringBuilder();
/* 885 */       _sb_.append("(");
/* 886 */       _sb_.append(this.question_id);
/* 887 */       _sb_.append(",");
/* 888 */       _sb_.append(this.answer_result);
/* 889 */       _sb_.append(",");
/* 890 */       _sb_.append(this.answer_time);
/* 891 */       _sb_.append(",");
/* 892 */       _sb_.append(this.answer_id);
/* 893 */       _sb_.append(")");
/* 894 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\MemoryQuestion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */