/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.io.IOException;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class ChatGiftTimeList extends XBean implements xbean.ChatGiftTimeList
/*     */ {
/*     */   private LinkedList<Long> chatgifttimelist;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.chatgifttimelist.clear();
/*     */   }
/*     */   
/*     */   ChatGiftTimeList(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.chatgifttimelist = new LinkedList();
/*     */   }
/*     */   
/*     */   public ChatGiftTimeList()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ChatGiftTimeList(ChatGiftTimeList _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ChatGiftTimeList(xbean.ChatGiftTimeList _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof ChatGiftTimeList)) { assign((ChatGiftTimeList)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ChatGiftTimeList _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.chatgifttimelist = new LinkedList();
/*  50 */     this.chatgifttimelist.addAll(_o_.chatgifttimelist);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  55 */     this.chatgifttimelist = new LinkedList();
/*  56 */     this.chatgifttimelist.addAll(_o_.chatgifttimelist);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  62 */     _xdb_verify_unsafe_();
/*  63 */     _os_.compact_uint32(this.chatgifttimelist.size());
/*  64 */     for (Long _v_ : this.chatgifttimelist)
/*     */     {
/*  66 */       _os_.marshal(_v_.longValue());
/*     */     }
/*  68 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  74 */     _xdb_verify_unsafe_();
/*  75 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */     {
/*  77 */       long _v_ = 0L;
/*  78 */       _v_ = _os_.unmarshal_long();
/*  79 */       this.chatgifttimelist.add(Long.valueOf(_v_));
/*     */     }
/*  81 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  87 */     _xdb_verify_unsafe_();
/*  88 */     int _size_ = 0;
/*  89 */     for (Long _v_ : this.chatgifttimelist)
/*     */     {
/*  91 */       _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */     }
/*  93 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  99 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 102 */       for (Long _v_ : this.chatgifttimelist)
/*     */       {
/* 104 */         _output_.writeInt64(1, _v_.longValue());
/*     */       }
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 109 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 111 */     return _output_;
/*     */   }
/*     */   
/*     */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/* 117 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 120 */       boolean done = false;
/* 121 */       while (!done)
/*     */       {
/* 123 */         int tag = _input_.readTag();
/* 124 */         switch (tag)
/*     */         {
/*     */ 
/*     */         case 0: 
/* 128 */           done = true;
/* 129 */           break;
/*     */         
/*     */ 
/*     */         case 8: 
/* 133 */           long _v_ = 0L;
/* 134 */           _v_ = _input_.readInt64();
/* 135 */           this.chatgifttimelist.add(Long.valueOf(_v_));
/* 136 */           break;
/*     */         
/*     */ 
/*     */         default: 
/* 140 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */           {
/* 142 */             done = true;
/*     */           }
/*     */           break;
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (InvalidProtocolBufferException e)
/*     */     {
/* 151 */       throw e.setUnfinishedMessage(this);
/*     */     }
/*     */     catch (IOException e)
/*     */     {
/* 155 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 157 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChatGiftTimeList copy()
/*     */   {
/* 163 */     _xdb_verify_unsafe_();
/* 164 */     return new ChatGiftTimeList(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChatGiftTimeList toData()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChatGiftTimeList toBean()
/*     */   {
/* 176 */     _xdb_verify_unsafe_();
/* 177 */     return new ChatGiftTimeList(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChatGiftTimeList toDataIf()
/*     */   {
/* 183 */     _xdb_verify_unsafe_();
/* 184 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChatGiftTimeList toBeanIf()
/*     */   {
/* 189 */     _xdb_verify_unsafe_();
/* 190 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 196 */     _xdb_verify_unsafe_();
/* 197 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public List<Long> getChatgifttimelist()
/*     */   {
/* 204 */     _xdb_verify_unsafe_();
/* 205 */     return xdb.Logs.logList(new xdb.LogKey(this, "chatgifttimelist"), this.chatgifttimelist);
/*     */   }
/*     */   
/*     */ 
/*     */   public List<Long> getChatgifttimelistAsData()
/*     */   {
/* 211 */     _xdb_verify_unsafe_();
/*     */     
/* 213 */     ChatGiftTimeList _o_ = this;
/* 214 */     List<Long> chatgifttimelist = new LinkedList();
/* 215 */     chatgifttimelist.addAll(_o_.chatgifttimelist);
/* 216 */     return chatgifttimelist;
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 222 */     _xdb_verify_unsafe_();
/* 223 */     ChatGiftTimeList _o_ = null;
/* 224 */     if ((_o1_ instanceof ChatGiftTimeList)) { _o_ = (ChatGiftTimeList)_o1_;
/* 225 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 226 */       return false;
/* 227 */     if (!this.chatgifttimelist.equals(_o_.chatgifttimelist)) return false;
/* 228 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 234 */     _xdb_verify_unsafe_();
/* 235 */     int _h_ = 0;
/* 236 */     _h_ += this.chatgifttimelist.hashCode();
/* 237 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 243 */     _xdb_verify_unsafe_();
/* 244 */     StringBuilder _sb_ = new StringBuilder();
/* 245 */     _sb_.append("(");
/* 246 */     _sb_.append(this.chatgifttimelist);
/* 247 */     _sb_.append(")");
/* 248 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 254 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 255 */     lb.add(new xdb.logs.ListenableChanged().setVarName("chatgifttimelist"));
/* 256 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ChatGiftTimeList {
/*     */     private Const() {}
/*     */     
/*     */     ChatGiftTimeList nThis() {
/* 263 */       return ChatGiftTimeList.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 269 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftTimeList copy()
/*     */     {
/* 275 */       return ChatGiftTimeList.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftTimeList toData()
/*     */     {
/* 281 */       return ChatGiftTimeList.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ChatGiftTimeList toBean()
/*     */     {
/* 286 */       return ChatGiftTimeList.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftTimeList toDataIf()
/*     */     {
/* 292 */       return ChatGiftTimeList.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ChatGiftTimeList toBeanIf()
/*     */     {
/* 297 */       return ChatGiftTimeList.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getChatgifttimelist()
/*     */     {
/* 304 */       ChatGiftTimeList.this._xdb_verify_unsafe_();
/* 305 */       return xdb.Consts.constList(ChatGiftTimeList.this.chatgifttimelist);
/*     */     }
/*     */     
/*     */ 
/*     */     public List<Long> getChatgifttimelistAsData()
/*     */     {
/* 311 */       ChatGiftTimeList.this._xdb_verify_unsafe_();
/*     */       
/* 313 */       ChatGiftTimeList _o_ = ChatGiftTimeList.this;
/* 314 */       List<Long> chatgifttimelist = new LinkedList();
/* 315 */       chatgifttimelist.addAll(_o_.chatgifttimelist);
/* 316 */       return chatgifttimelist;
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 322 */       ChatGiftTimeList.this._xdb_verify_unsafe_();
/* 323 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 329 */       ChatGiftTimeList.this._xdb_verify_unsafe_();
/* 330 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 336 */       return ChatGiftTimeList.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 342 */       return ChatGiftTimeList.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 348 */       ChatGiftTimeList.this._xdb_verify_unsafe_();
/* 349 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 355 */       return ChatGiftTimeList.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 361 */       return ChatGiftTimeList.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 367 */       ChatGiftTimeList.this._xdb_verify_unsafe_();
/* 368 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 374 */       return ChatGiftTimeList.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 380 */       return ChatGiftTimeList.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 386 */       return ChatGiftTimeList.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 392 */       return ChatGiftTimeList.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 398 */       return ChatGiftTimeList.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 404 */       return ChatGiftTimeList.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 410 */       return ChatGiftTimeList.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ChatGiftTimeList
/*     */   {
/*     */     private LinkedList<Long> chatgifttimelist;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 422 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 427 */       this.chatgifttimelist = new LinkedList();
/*     */     }
/*     */     
/*     */     Data(xbean.ChatGiftTimeList _o1_)
/*     */     {
/* 432 */       if ((_o1_ instanceof ChatGiftTimeList)) { assign((ChatGiftTimeList)_o1_);
/* 433 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 434 */       } else if ((_o1_ instanceof ChatGiftTimeList.Const)) assign(((ChatGiftTimeList.Const)_o1_).nThis()); else {
/* 435 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ChatGiftTimeList _o_) {
/* 440 */       this.chatgifttimelist = new LinkedList();
/* 441 */       this.chatgifttimelist.addAll(_o_.chatgifttimelist);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 446 */       this.chatgifttimelist = new LinkedList();
/* 447 */       this.chatgifttimelist.addAll(_o_.chatgifttimelist);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 453 */       _os_.compact_uint32(this.chatgifttimelist.size());
/* 454 */       for (Long _v_ : this.chatgifttimelist)
/*     */       {
/* 456 */         _os_.marshal(_v_.longValue());
/*     */       }
/* 458 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 464 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*     */       {
/* 466 */         long _v_ = 0L;
/* 467 */         _v_ = _os_.unmarshal_long();
/* 468 */         this.chatgifttimelist.add(Long.valueOf(_v_));
/*     */       }
/* 470 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 476 */       int _size_ = 0;
/* 477 */       for (Long _v_ : this.chatgifttimelist)
/*     */       {
/* 479 */         _size_ += CodedOutputStream.computeInt64Size(1, _v_.longValue());
/*     */       }
/* 481 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 489 */         for (Long _v_ : this.chatgifttimelist)
/*     */         {
/* 491 */           _output_.writeInt64(1, _v_.longValue());
/*     */         }
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 496 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 498 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 506 */         boolean done = false;
/* 507 */         while (!done)
/*     */         {
/* 509 */           int tag = _input_.readTag();
/* 510 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 514 */             done = true;
/* 515 */             break;
/*     */           
/*     */ 
/*     */           case 8: 
/* 519 */             long _v_ = 0L;
/* 520 */             _v_ = _input_.readInt64();
/* 521 */             this.chatgifttimelist.add(Long.valueOf(_v_));
/* 522 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 526 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 528 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 537 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (IOException e)
/*     */       {
/* 541 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 543 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftTimeList copy()
/*     */     {
/* 549 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftTimeList toData()
/*     */     {
/* 555 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ChatGiftTimeList toBean()
/*     */     {
/* 560 */       return new ChatGiftTimeList(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatGiftTimeList toDataIf()
/*     */     {
/* 566 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ChatGiftTimeList toBeanIf()
/*     */     {
/* 571 */       return new ChatGiftTimeList(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 577 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 581 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 585 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 589 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 593 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 597 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 601 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getChatgifttimelist()
/*     */     {
/* 608 */       return this.chatgifttimelist;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public List<Long> getChatgifttimelistAsData()
/*     */     {
/* 615 */       return this.chatgifttimelist;
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 621 */       if (!(_o1_ instanceof Data)) return false;
/* 622 */       Data _o_ = (Data)_o1_;
/* 623 */       if (!this.chatgifttimelist.equals(_o_.chatgifttimelist)) return false;
/* 624 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 630 */       int _h_ = 0;
/* 631 */       _h_ += this.chatgifttimelist.hashCode();
/* 632 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 638 */       StringBuilder _sb_ = new StringBuilder();
/* 639 */       _sb_.append("(");
/* 640 */       _sb_.append(this.chatgifttimelist);
/* 641 */       _sb_.append(")");
/* 642 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChatGiftTimeList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */