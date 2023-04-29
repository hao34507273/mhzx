/*     */ package xbean.__;
/*     */ 
/*     */ import com.goldhuman.Common.Marshal.Marshal;
/*     */ import com.goldhuman.Common.Marshal.OctetsStream;
/*     */ import java.util.Arrays;
/*     */ import ppbio.CodedInputStream;
/*     */ import ppbio.CodedOutputStream;
/*     */ import ppbio.InvalidProtocolBufferException;
/*     */ import xdb.LogKey;
/*     */ import xdb.XBean;
/*     */ 
/*     */ public final class ChatDataBean extends XBean implements xbean.ChatDataBean
/*     */ {
/*     */   private byte[] chatdata;
/*     */   
/*     */   public void _reset_unsafe_()
/*     */   {
/*  18 */     this.chatdata = new byte[0];
/*     */   }
/*     */   
/*     */   ChatDataBean(int __, XBean _xp_, String _vn_)
/*     */   {
/*  23 */     super(_xp_, _vn_);
/*  24 */     this.chatdata = new byte[0];
/*     */   }
/*     */   
/*     */   public ChatDataBean()
/*     */   {
/*  29 */     this(0, null, null);
/*     */   }
/*     */   
/*     */   public ChatDataBean(ChatDataBean _o_)
/*     */   {
/*  34 */     this(_o_, null, null);
/*     */   }
/*     */   
/*     */   ChatDataBean(xbean.ChatDataBean _o1_, XBean _xp_, String _vn_)
/*     */   {
/*  39 */     super(_xp_, _vn_);
/*  40 */     if ((_o1_ instanceof ChatDataBean)) { assign((ChatDataBean)_o1_);
/*  41 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  42 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*  43 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */   
/*     */   private void assign(ChatDataBean _o_) {
/*  48 */     _o_._xdb_verify_unsafe_();
/*  49 */     this.chatdata = Arrays.copyOf(_o_.chatdata, _o_.chatdata.length);
/*     */   }
/*     */   
/*     */   private void assign(Data _o_)
/*     */   {
/*  54 */     this.chatdata = Arrays.copyOf(_o_.chatdata, _o_.chatdata.length);
/*     */   }
/*     */   
/*     */ 
/*     */   public final OctetsStream marshal(OctetsStream _os_)
/*     */   {
/*  60 */     _xdb_verify_unsafe_();
/*  61 */     _os_.marshal(this.chatdata);
/*  62 */     return _os_;
/*     */   }
/*     */   
/*     */   public final OctetsStream unmarshal(OctetsStream _os_)
/*     */     throws com.goldhuman.Common.Marshal.MarshalException
/*     */   {
/*  68 */     _xdb_verify_unsafe_();
/*  69 */     this.chatdata = _os_.unmarshal_bytes();
/*  70 */     return _os_;
/*     */   }
/*     */   
/*     */ 
/*     */   public int getSerializedSize()
/*     */   {
/*  76 */     _xdb_verify_unsafe_();
/*  77 */     int _size_ = 0;
/*  78 */     _size_ += CodedOutputStream.computeByteArraySize(1, this.chatdata);
/*  79 */     return _size_;
/*     */   }
/*     */   
/*     */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */     throws InvalidProtocolBufferException
/*     */   {
/*  85 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/*  88 */       _output_.writeByteArray(1, this.chatdata);
/*     */     }
/*     */     catch (java.io.IOException e)
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
/* 116 */           this.chatdata = _input_.readByteArray();
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
/*     */     catch (java.io.IOException e)
/*     */     {
/* 136 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */     }
/* 138 */     return _input_;
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChatDataBean copy()
/*     */   {
/* 144 */     _xdb_verify_unsafe_();
/* 145 */     return new ChatDataBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChatDataBean toData()
/*     */   {
/* 151 */     _xdb_verify_unsafe_();
/* 152 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChatDataBean toBean()
/*     */   {
/* 157 */     _xdb_verify_unsafe_();
/* 158 */     return new ChatDataBean(this);
/*     */   }
/*     */   
/*     */ 
/*     */   public xbean.ChatDataBean toDataIf()
/*     */   {
/* 164 */     _xdb_verify_unsafe_();
/* 165 */     return new Data(this);
/*     */   }
/*     */   
/*     */   public xbean.ChatDataBean toBeanIf()
/*     */   {
/* 170 */     _xdb_verify_unsafe_();
/* 171 */     return this;
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.Bean toConst()
/*     */   {
/* 177 */     _xdb_verify_unsafe_();
/* 178 */     return new Const(null);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public <T extends Marshal> T getChatdata(T _v_)
/*     */   {
/* 185 */     _xdb_verify_unsafe_();
/*     */     try
/*     */     {
/* 188 */       _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.chatdata)));
/* 189 */       return _v_;
/*     */     }
/*     */     catch (com.goldhuman.Common.Marshal.MarshalException _e_)
/*     */     {
/* 193 */       throw new xio.MarshalError();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public boolean isChatdataEmpty()
/*     */   {
/* 201 */     _xdb_verify_unsafe_();
/* 202 */     return this.chatdata.length == 0;
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public byte[] getChatdataCopy()
/*     */   {
/* 209 */     _xdb_verify_unsafe_();
/* 210 */     return Arrays.copyOf(this.chatdata, this.chatdata.length);
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setChatdata(Marshal _v_)
/*     */   {
/* 217 */     _xdb_verify_unsafe_();
/* 218 */     xdb.Logs.logIf(new LogKey(this, "chatdata")
/*     */     {
/*     */       protected xdb.Log create()
/*     */       {
/* 222 */         new xdb.logs.LogObject(this, ChatDataBean.this.chatdata)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 226 */             ChatDataBean.this.chatdata = ((byte[])this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 230 */     });
/* 231 */     this.chatdata = _v_.marshal(new OctetsStream()).getBytes();
/*     */   }
/*     */   
/*     */ 
/*     */ 
/*     */   public void setChatdataCopy(byte[] _v_)
/*     */   {
/* 238 */     _xdb_verify_unsafe_();
/* 239 */     xdb.Logs.logIf(new LogKey(this, "chatdata")
/*     */     {
/*     */       protected xdb.Log create() {
/* 242 */         new xdb.logs.LogObject(this, ChatDataBean.this.chatdata)
/*     */         {
/*     */           public void rollback()
/*     */           {
/* 246 */             ChatDataBean.this.chatdata = ((byte[])this._xdb_saved);
/*     */           }
/*     */         };
/*     */       }
/* 250 */     });
/* 251 */     this.chatdata = Arrays.copyOf(_v_, _v_.length);
/*     */   }
/*     */   
/*     */ 
/*     */   public final boolean equals(Object _o1_)
/*     */   {
/* 257 */     _xdb_verify_unsafe_();
/* 258 */     ChatDataBean _o_ = null;
/* 259 */     if ((_o1_ instanceof ChatDataBean)) { _o_ = (ChatDataBean)_o1_;
/* 260 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/* 261 */       return false;
/* 262 */     if (!Arrays.equals(this.chatdata, _o_.chatdata)) return false;
/* 263 */     return true;
/*     */   }
/*     */   
/*     */ 
/*     */   public final int hashCode()
/*     */   {
/* 269 */     _xdb_verify_unsafe_();
/* 270 */     int _h_ = 0;
/* 271 */     _h_ += Arrays.hashCode(this.chatdata);
/* 272 */     return _h_;
/*     */   }
/*     */   
/*     */ 
/*     */   public String toString()
/*     */   {
/* 278 */     _xdb_verify_unsafe_();
/* 279 */     StringBuilder _sb_ = new StringBuilder();
/* 280 */     _sb_.append("(");
/* 281 */     _sb_.append('B').append(this.chatdata.length);
/* 282 */     _sb_.append(")");
/* 283 */     return _sb_.toString();
/*     */   }
/*     */   
/*     */ 
/*     */   public xdb.logs.Listenable newListenable()
/*     */   {
/* 289 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/* 290 */     lb.add(new xdb.logs.ListenableChanged().setVarName("chatdata"));
/* 291 */     return lb;
/*     */   }
/*     */   
/*     */   private class Const implements xbean.ChatDataBean {
/*     */     private Const() {}
/*     */     
/*     */     ChatDataBean nThis() {
/* 298 */       return ChatDataBean.this;
/*     */     }
/*     */     
/*     */ 
/*     */     public void _reset_unsafe_()
/*     */     {
/* 304 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatDataBean copy()
/*     */     {
/* 310 */       return ChatDataBean.this.copy();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatDataBean toData()
/*     */     {
/* 316 */       return ChatDataBean.this.toData();
/*     */     }
/*     */     
/*     */     public xbean.ChatDataBean toBean()
/*     */     {
/* 321 */       return ChatDataBean.this.toBean();
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatDataBean toDataIf()
/*     */     {
/* 327 */       return ChatDataBean.this.toDataIf();
/*     */     }
/*     */     
/*     */     public xbean.ChatDataBean toBeanIf()
/*     */     {
/* 332 */       return ChatDataBean.this.toBeanIf();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public <T extends Marshal> T getChatdata(T _v_)
/*     */     {
/* 339 */       ChatDataBean.this._xdb_verify_unsafe_();
/* 340 */       return ChatDataBean.this.getChatdata(_v_);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean isChatdataEmpty()
/*     */     {
/* 347 */       ChatDataBean.this._xdb_verify_unsafe_();
/* 348 */       return ChatDataBean.this.isChatdataEmpty();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public byte[] getChatdataCopy()
/*     */     {
/* 355 */       ChatDataBean.this._xdb_verify_unsafe_();
/* 356 */       return ChatDataBean.this.getChatdataCopy();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChatdata(Marshal _v_)
/*     */     {
/* 363 */       ChatDataBean.this._xdb_verify_unsafe_();
/* 364 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChatdataCopy(byte[] _v_)
/*     */     {
/* 371 */       ChatDataBean.this._xdb_verify_unsafe_();
/* 372 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean toConst()
/*     */     {
/* 378 */       ChatDataBean.this._xdb_verify_unsafe_();
/* 379 */       return this;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isConst()
/*     */     {
/* 385 */       ChatDataBean.this._xdb_verify_unsafe_();
/* 386 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean isData()
/*     */     {
/* 392 */       return ChatDataBean.this.isData();
/*     */     }
/*     */     
/*     */ 
/*     */     public OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 398 */       return ChatDataBean.this.marshal(_os_);
/*     */     }
/*     */     
/*     */     public OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 404 */       ChatDataBean.this._xdb_verify_unsafe_();
/* 405 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public int getSerializedSize()
/*     */     {
/* 411 */       return ChatDataBean.this.getSerializedSize();
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 417 */       return ChatDataBean.this.marshal(_output_);
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/* 423 */       ChatDataBean.this._xdb_verify_unsafe_();
/* 424 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */ 
/*     */     public xdb.Bean xdbParent()
/*     */     {
/* 430 */       return ChatDataBean.this.xdbParent();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 436 */       return ChatDataBean.this.xdbManaged();
/*     */     }
/*     */     
/*     */ 
/*     */     public String xdbVarname()
/*     */     {
/* 442 */       return ChatDataBean.this.xdbVarname();
/*     */     }
/*     */     
/*     */ 
/*     */     public Long xdbObjId()
/*     */     {
/* 448 */       return ChatDataBean.this.xdbObjId();
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean equals(Object obj)
/*     */     {
/* 454 */       return ChatDataBean.this.equals(obj);
/*     */     }
/*     */     
/*     */ 
/*     */     public int hashCode()
/*     */     {
/* 460 */       return ChatDataBean.this.hashCode();
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 466 */       return ChatDataBean.this.toString();
/*     */     }
/*     */   }
/*     */   
/*     */ 
/*     */   public static final class Data
/*     */     implements xbean.ChatDataBean
/*     */   {
/*     */     private byte[] chatdata;
/*     */     
/*     */     public void _reset_unsafe_()
/*     */     {
/* 478 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Data()
/*     */     {
/* 483 */       this.chatdata = new byte[0];
/*     */     }
/*     */     
/*     */     Data(xbean.ChatDataBean _o1_)
/*     */     {
/* 488 */       if ((_o1_ instanceof ChatDataBean)) { assign((ChatDataBean)_o1_);
/* 489 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 490 */       } else if ((_o1_ instanceof ChatDataBean.Const)) assign(((ChatDataBean.Const)_o1_).nThis()); else {
/* 491 */         throw new UnsupportedOperationException();
/*     */       }
/*     */     }
/*     */     
/*     */     private void assign(ChatDataBean _o_) {
/* 496 */       this.chatdata = Arrays.copyOf(_o_.chatdata, _o_.chatdata.length);
/*     */     }
/*     */     
/*     */     private void assign(Data _o_)
/*     */     {
/* 501 */       this.chatdata = Arrays.copyOf(_o_.chatdata, _o_.chatdata.length);
/*     */     }
/*     */     
/*     */ 
/*     */     public final OctetsStream marshal(OctetsStream _os_)
/*     */     {
/* 507 */       _os_.marshal(this.chatdata);
/* 508 */       return _os_;
/*     */     }
/*     */     
/*     */     public final OctetsStream unmarshal(OctetsStream _os_)
/*     */       throws com.goldhuman.Common.Marshal.MarshalException
/*     */     {
/* 514 */       this.chatdata = _os_.unmarshal_bytes();
/* 515 */       return _os_;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int getSerializedSize()
/*     */     {
/* 521 */       int _size_ = 0;
/* 522 */       _size_ += CodedOutputStream.computeByteArraySize(1, this.chatdata);
/* 523 */       return _size_;
/*     */     }
/*     */     
/*     */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 531 */         _output_.writeByteArray(1, this.chatdata);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 535 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 537 */       return _output_;
/*     */     }
/*     */     
/*     */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*     */       throws InvalidProtocolBufferException
/*     */     {
/*     */       try
/*     */       {
/* 545 */         boolean done = false;
/* 546 */         while (!done)
/*     */         {
/* 548 */           int tag = _input_.readTag();
/* 549 */           switch (tag)
/*     */           {
/*     */ 
/*     */           case 0: 
/* 553 */             done = true;
/* 554 */             break;
/*     */           
/*     */ 
/*     */           case 10: 
/* 558 */             this.chatdata = _input_.readByteArray();
/* 559 */             break;
/*     */           
/*     */ 
/*     */           default: 
/* 563 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*     */             {
/* 565 */               done = true;
/*     */             }
/*     */             break;
/*     */           }
/*     */           
/*     */         }
/*     */       }
/*     */       catch (InvalidProtocolBufferException e)
/*     */       {
/* 574 */         throw e.setUnfinishedMessage(this);
/*     */       }
/*     */       catch (java.io.IOException e)
/*     */       {
/* 578 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*     */       }
/* 580 */       return _input_;
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatDataBean copy()
/*     */     {
/* 586 */       return new Data(this);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatDataBean toData()
/*     */     {
/* 592 */       return new Data(this);
/*     */     }
/*     */     
/*     */     public xbean.ChatDataBean toBean()
/*     */     {
/* 597 */       return new ChatDataBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public xbean.ChatDataBean toDataIf()
/*     */     {
/* 603 */       return this;
/*     */     }
/*     */     
/*     */     public xbean.ChatDataBean toBeanIf()
/*     */     {
/* 608 */       return new ChatDataBean(this, null, null);
/*     */     }
/*     */     
/*     */ 
/*     */     public boolean xdbManaged()
/*     */     {
/* 614 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean xdbParent() {
/* 618 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public String xdbVarname() {
/* 622 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public Long xdbObjId() {
/* 626 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public xdb.Bean toConst() {
/* 630 */       throw new UnsupportedOperationException();
/*     */     }
/*     */     
/*     */     public boolean isConst() {
/* 634 */       return false;
/*     */     }
/*     */     
/*     */     public boolean isData() {
/* 638 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public <T extends Marshal> T getChatdata(T _v_)
/*     */     {
/*     */       try
/*     */       {
/* 647 */         _v_.unmarshal(OctetsStream.wrap(com.goldhuman.Common.Octets.wrap(this.chatdata)));
/* 648 */         return _v_;
/*     */       }
/*     */       catch (com.goldhuman.Common.Marshal.MarshalException _e_)
/*     */       {
/* 652 */         throw new xio.MarshalError();
/*     */       }
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public boolean isChatdataEmpty()
/*     */     {
/* 660 */       return this.chatdata.length == 0;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public byte[] getChatdataCopy()
/*     */     {
/* 667 */       return Arrays.copyOf(this.chatdata, this.chatdata.length);
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChatdata(Marshal _v_)
/*     */     {
/* 674 */       this.chatdata = _v_.marshal(new OctetsStream()).getBytes();
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */     public void setChatdataCopy(byte[] _v_)
/*     */     {
/* 681 */       this.chatdata = Arrays.copyOf(_v_, _v_.length);
/*     */     }
/*     */     
/*     */ 
/*     */     public final boolean equals(Object _o1_)
/*     */     {
/* 687 */       if (!(_o1_ instanceof Data)) return false;
/* 688 */       Data _o_ = (Data)_o1_;
/* 689 */       if (!Arrays.equals(this.chatdata, _o_.chatdata)) return false;
/* 690 */       return true;
/*     */     }
/*     */     
/*     */ 
/*     */     public final int hashCode()
/*     */     {
/* 696 */       int _h_ = 0;
/* 697 */       _h_ += Arrays.hashCode(this.chatdata);
/* 698 */       return _h_;
/*     */     }
/*     */     
/*     */ 
/*     */     public String toString()
/*     */     {
/* 704 */       StringBuilder _sb_ = new StringBuilder();
/* 705 */       _sb_.append("(");
/* 706 */       _sb_.append('B').append(this.chatdata.length);
/* 707 */       _sb_.append(")");
/* 708 */       return _sb_.toString();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\ChatDataBean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */