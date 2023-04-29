/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.Log;
/*      */ import xdb.LogKey;
/*      */ import xdb.Logs;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ import xdb.logs.LogLong;
/*      */ import xdb.logs.LogString;
/*      */ 
/*      */ public final class TssSumInfo extends XBean implements xbean.TssSumInfo
/*      */ {
/*      */   private long first_buy_time;
/*      */   private long begin_time;
/*      */   private long end_time;
/*      */   private long grandtotal_opendays;
/*      */   private long grandtotal_presentdays;
/*      */   private String paychan;
/*      */   private String paysubchan;
/*      */   private String autopaychan;
/*      */   private String autopaysubchan;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.first_buy_time = 0L;
/*   35 */     this.begin_time = 0L;
/*   36 */     this.end_time = 0L;
/*   37 */     this.grandtotal_opendays = 0L;
/*   38 */     this.grandtotal_presentdays = 0L;
/*   39 */     this.paychan = "";
/*   40 */     this.paysubchan = "";
/*   41 */     this.autopaychan = "";
/*   42 */     this.autopaysubchan = "";
/*      */   }
/*      */   
/*      */   TssSumInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.first_buy_time = 0L;
/*   49 */     this.paychan = "";
/*   50 */     this.paysubchan = "";
/*   51 */     this.autopaychan = "";
/*   52 */     this.autopaysubchan = "";
/*      */   }
/*      */   
/*      */   public TssSumInfo()
/*      */   {
/*   57 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public TssSumInfo(TssSumInfo _o_)
/*      */   {
/*   62 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   TssSumInfo(xbean.TssSumInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   67 */     super(_xp_, _vn_);
/*   68 */     if ((_o1_ instanceof TssSumInfo)) { assign((TssSumInfo)_o1_);
/*   69 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   70 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   71 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(TssSumInfo _o_) {
/*   76 */     _o_._xdb_verify_unsafe_();
/*   77 */     this.first_buy_time = _o_.first_buy_time;
/*   78 */     this.begin_time = _o_.begin_time;
/*   79 */     this.end_time = _o_.end_time;
/*   80 */     this.grandtotal_opendays = _o_.grandtotal_opendays;
/*   81 */     this.grandtotal_presentdays = _o_.grandtotal_presentdays;
/*   82 */     this.paychan = _o_.paychan;
/*   83 */     this.paysubchan = _o_.paysubchan;
/*   84 */     this.autopaychan = _o_.autopaychan;
/*   85 */     this.autopaysubchan = _o_.autopaysubchan;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   90 */     this.first_buy_time = _o_.first_buy_time;
/*   91 */     this.begin_time = _o_.begin_time;
/*   92 */     this.end_time = _o_.end_time;
/*   93 */     this.grandtotal_opendays = _o_.grandtotal_opendays;
/*   94 */     this.grandtotal_presentdays = _o_.grandtotal_presentdays;
/*   95 */     this.paychan = _o_.paychan;
/*   96 */     this.paysubchan = _o_.paysubchan;
/*   97 */     this.autopaychan = _o_.autopaychan;
/*   98 */     this.autopaysubchan = _o_.autopaysubchan;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  104 */     _xdb_verify_unsafe_();
/*  105 */     _os_.marshal(this.first_buy_time);
/*  106 */     _os_.marshal(this.begin_time);
/*  107 */     _os_.marshal(this.end_time);
/*  108 */     _os_.marshal(this.grandtotal_opendays);
/*  109 */     _os_.marshal(this.grandtotal_presentdays);
/*  110 */     _os_.marshal(this.paychan, "UTF-16LE");
/*  111 */     _os_.marshal(this.paysubchan, "UTF-16LE");
/*  112 */     _os_.marshal(this.autopaychan, "UTF-16LE");
/*  113 */     _os_.marshal(this.autopaysubchan, "UTF-16LE");
/*  114 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  120 */     _xdb_verify_unsafe_();
/*  121 */     this.first_buy_time = _os_.unmarshal_long();
/*  122 */     this.begin_time = _os_.unmarshal_long();
/*  123 */     this.end_time = _os_.unmarshal_long();
/*  124 */     this.grandtotal_opendays = _os_.unmarshal_long();
/*  125 */     this.grandtotal_presentdays = _os_.unmarshal_long();
/*  126 */     this.paychan = _os_.unmarshal_String("UTF-16LE");
/*  127 */     this.paysubchan = _os_.unmarshal_String("UTF-16LE");
/*  128 */     this.autopaychan = _os_.unmarshal_String("UTF-16LE");
/*  129 */     this.autopaysubchan = _os_.unmarshal_String("UTF-16LE");
/*  130 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  136 */     _xdb_verify_unsafe_();
/*  137 */     int _size_ = 0;
/*  138 */     _size_ += CodedOutputStream.computeInt64Size(1, this.first_buy_time);
/*  139 */     _size_ += CodedOutputStream.computeInt64Size(2, this.begin_time);
/*  140 */     _size_ += CodedOutputStream.computeInt64Size(3, this.end_time);
/*  141 */     _size_ += CodedOutputStream.computeInt64Size(4, this.grandtotal_opendays);
/*  142 */     _size_ += CodedOutputStream.computeInt64Size(5, this.grandtotal_presentdays);
/*      */     try
/*      */     {
/*  145 */       _size_ += CodedOutputStream.computeBytesSize(6, ByteString.copyFrom(this.paychan, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  149 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  153 */       _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.paysubchan, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  157 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  161 */       _size_ += CodedOutputStream.computeBytesSize(8, ByteString.copyFrom(this.autopaychan, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  165 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  169 */       _size_ += CodedOutputStream.computeBytesSize(9, ByteString.copyFrom(this.autopaysubchan, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  173 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  175 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  181 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  184 */       _output_.writeInt64(1, this.first_buy_time);
/*  185 */       _output_.writeInt64(2, this.begin_time);
/*  186 */       _output_.writeInt64(3, this.end_time);
/*  187 */       _output_.writeInt64(4, this.grandtotal_opendays);
/*  188 */       _output_.writeInt64(5, this.grandtotal_presentdays);
/*  189 */       _output_.writeBytes(6, ByteString.copyFrom(this.paychan, "UTF-16LE"));
/*  190 */       _output_.writeBytes(7, ByteString.copyFrom(this.paysubchan, "UTF-16LE"));
/*  191 */       _output_.writeBytes(8, ByteString.copyFrom(this.autopaychan, "UTF-16LE"));
/*  192 */       _output_.writeBytes(9, ByteString.copyFrom(this.autopaysubchan, "UTF-16LE"));
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  196 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  198 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  204 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  207 */       boolean done = false;
/*  208 */       while (!done)
/*      */       {
/*  210 */         int tag = _input_.readTag();
/*  211 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  215 */           done = true;
/*  216 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  220 */           this.first_buy_time = _input_.readInt64();
/*  221 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  225 */           this.begin_time = _input_.readInt64();
/*  226 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  230 */           this.end_time = _input_.readInt64();
/*  231 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  235 */           this.grandtotal_opendays = _input_.readInt64();
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  240 */           this.grandtotal_presentdays = _input_.readInt64();
/*  241 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  245 */           this.paychan = _input_.readBytes().toString("UTF-16LE");
/*  246 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  250 */           this.paysubchan = _input_.readBytes().toString("UTF-16LE");
/*  251 */           break;
/*      */         
/*      */ 
/*      */         case 66: 
/*  255 */           this.autopaychan = _input_.readBytes().toString("UTF-16LE");
/*  256 */           break;
/*      */         
/*      */ 
/*      */         case 74: 
/*  260 */           this.autopaysubchan = _input_.readBytes().toString("UTF-16LE");
/*  261 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  265 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  267 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  276 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  280 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  282 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TssSumInfo copy()
/*      */   {
/*  288 */     _xdb_verify_unsafe_();
/*  289 */     return new TssSumInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TssSumInfo toData()
/*      */   {
/*  295 */     _xdb_verify_unsafe_();
/*  296 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.TssSumInfo toBean()
/*      */   {
/*  301 */     _xdb_verify_unsafe_();
/*  302 */     return new TssSumInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.TssSumInfo toDataIf()
/*      */   {
/*  308 */     _xdb_verify_unsafe_();
/*  309 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.TssSumInfo toBeanIf()
/*      */   {
/*  314 */     _xdb_verify_unsafe_();
/*  315 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  321 */     _xdb_verify_unsafe_();
/*  322 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getFirst_buy_time()
/*      */   {
/*  329 */     _xdb_verify_unsafe_();
/*  330 */     return this.first_buy_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBegin_time()
/*      */   {
/*  337 */     _xdb_verify_unsafe_();
/*  338 */     return this.begin_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEnd_time()
/*      */   {
/*  345 */     _xdb_verify_unsafe_();
/*  346 */     return this.end_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGrandtotal_opendays()
/*      */   {
/*  353 */     _xdb_verify_unsafe_();
/*  354 */     return this.grandtotal_opendays;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getGrandtotal_presentdays()
/*      */   {
/*  361 */     _xdb_verify_unsafe_();
/*  362 */     return this.grandtotal_presentdays;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getPaychan()
/*      */   {
/*  369 */     _xdb_verify_unsafe_();
/*  370 */     return this.paychan;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getPaychanOctets()
/*      */   {
/*  377 */     _xdb_verify_unsafe_();
/*  378 */     return Octets.wrap(getPaychan(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getPaysubchan()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*  386 */     return this.paysubchan;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getPaysubchanOctets()
/*      */   {
/*  393 */     _xdb_verify_unsafe_();
/*  394 */     return Octets.wrap(getPaysubchan(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getAutopaychan()
/*      */   {
/*  401 */     _xdb_verify_unsafe_();
/*  402 */     return this.autopaychan;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getAutopaychanOctets()
/*      */   {
/*  409 */     _xdb_verify_unsafe_();
/*  410 */     return Octets.wrap(getAutopaychan(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getAutopaysubchan()
/*      */   {
/*  417 */     _xdb_verify_unsafe_();
/*  418 */     return this.autopaysubchan;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getAutopaysubchanOctets()
/*      */   {
/*  425 */     _xdb_verify_unsafe_();
/*  426 */     return Octets.wrap(getAutopaysubchan(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setFirst_buy_time(long _v_)
/*      */   {
/*  433 */     _xdb_verify_unsafe_();
/*  434 */     Logs.logIf(new LogKey(this, "first_buy_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  438 */         new LogLong(this, TssSumInfo.this.first_buy_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  442 */             TssSumInfo.this.first_buy_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  446 */     });
/*  447 */     this.first_buy_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBegin_time(long _v_)
/*      */   {
/*  454 */     _xdb_verify_unsafe_();
/*  455 */     Logs.logIf(new LogKey(this, "begin_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  459 */         new LogLong(this, TssSumInfo.this.begin_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  463 */             TssSumInfo.this.begin_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  467 */     });
/*  468 */     this.begin_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEnd_time(long _v_)
/*      */   {
/*  475 */     _xdb_verify_unsafe_();
/*  476 */     Logs.logIf(new LogKey(this, "end_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  480 */         new LogLong(this, TssSumInfo.this.end_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  484 */             TssSumInfo.this.end_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  488 */     });
/*  489 */     this.end_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGrandtotal_opendays(long _v_)
/*      */   {
/*  496 */     _xdb_verify_unsafe_();
/*  497 */     Logs.logIf(new LogKey(this, "grandtotal_opendays")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  501 */         new LogLong(this, TssSumInfo.this.grandtotal_opendays)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  505 */             TssSumInfo.this.grandtotal_opendays = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  509 */     });
/*  510 */     this.grandtotal_opendays = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setGrandtotal_presentdays(long _v_)
/*      */   {
/*  517 */     _xdb_verify_unsafe_();
/*  518 */     Logs.logIf(new LogKey(this, "grandtotal_presentdays")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  522 */         new LogLong(this, TssSumInfo.this.grandtotal_presentdays)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  526 */             TssSumInfo.this.grandtotal_presentdays = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  530 */     });
/*  531 */     this.grandtotal_presentdays = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPaychan(String _v_)
/*      */   {
/*  538 */     _xdb_verify_unsafe_();
/*  539 */     if (null == _v_)
/*  540 */       throw new NullPointerException();
/*  541 */     Logs.logIf(new LogKey(this, "paychan")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  545 */         new LogString(this, TssSumInfo.this.paychan)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  549 */             TssSumInfo.this.paychan = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  553 */     });
/*  554 */     this.paychan = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPaychanOctets(Octets _v_)
/*      */   {
/*  561 */     _xdb_verify_unsafe_();
/*  562 */     setPaychan(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPaysubchan(String _v_)
/*      */   {
/*  569 */     _xdb_verify_unsafe_();
/*  570 */     if (null == _v_)
/*  571 */       throw new NullPointerException();
/*  572 */     Logs.logIf(new LogKey(this, "paysubchan")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  576 */         new LogString(this, TssSumInfo.this.paysubchan)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  580 */             TssSumInfo.this.paysubchan = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  584 */     });
/*  585 */     this.paysubchan = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setPaysubchanOctets(Octets _v_)
/*      */   {
/*  592 */     _xdb_verify_unsafe_();
/*  593 */     setPaysubchan(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAutopaychan(String _v_)
/*      */   {
/*  600 */     _xdb_verify_unsafe_();
/*  601 */     if (null == _v_)
/*  602 */       throw new NullPointerException();
/*  603 */     Logs.logIf(new LogKey(this, "autopaychan")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  607 */         new LogString(this, TssSumInfo.this.autopaychan)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  611 */             TssSumInfo.this.autopaychan = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  615 */     });
/*  616 */     this.autopaychan = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAutopaychanOctets(Octets _v_)
/*      */   {
/*  623 */     _xdb_verify_unsafe_();
/*  624 */     setAutopaychan(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAutopaysubchan(String _v_)
/*      */   {
/*  631 */     _xdb_verify_unsafe_();
/*  632 */     if (null == _v_)
/*  633 */       throw new NullPointerException();
/*  634 */     Logs.logIf(new LogKey(this, "autopaysubchan")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  638 */         new LogString(this, TssSumInfo.this.autopaysubchan)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  642 */             TssSumInfo.this.autopaysubchan = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  646 */     });
/*  647 */     this.autopaysubchan = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setAutopaysubchanOctets(Octets _v_)
/*      */   {
/*  654 */     _xdb_verify_unsafe_();
/*  655 */     setAutopaysubchan(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  661 */     _xdb_verify_unsafe_();
/*  662 */     TssSumInfo _o_ = null;
/*  663 */     if ((_o1_ instanceof TssSumInfo)) { _o_ = (TssSumInfo)_o1_;
/*  664 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  665 */       return false;
/*  666 */     if (this.first_buy_time != _o_.first_buy_time) return false;
/*  667 */     if (this.begin_time != _o_.begin_time) return false;
/*  668 */     if (this.end_time != _o_.end_time) return false;
/*  669 */     if (this.grandtotal_opendays != _o_.grandtotal_opendays) return false;
/*  670 */     if (this.grandtotal_presentdays != _o_.grandtotal_presentdays) return false;
/*  671 */     if (!this.paychan.equals(_o_.paychan)) return false;
/*  672 */     if (!this.paysubchan.equals(_o_.paysubchan)) return false;
/*  673 */     if (!this.autopaychan.equals(_o_.autopaychan)) return false;
/*  674 */     if (!this.autopaysubchan.equals(_o_.autopaysubchan)) return false;
/*  675 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  681 */     _xdb_verify_unsafe_();
/*  682 */     int _h_ = 0;
/*  683 */     _h_ = (int)(_h_ + this.first_buy_time);
/*  684 */     _h_ = (int)(_h_ + this.begin_time);
/*  685 */     _h_ = (int)(_h_ + this.end_time);
/*  686 */     _h_ = (int)(_h_ + this.grandtotal_opendays);
/*  687 */     _h_ = (int)(_h_ + this.grandtotal_presentdays);
/*  688 */     _h_ += this.paychan.hashCode();
/*  689 */     _h_ += this.paysubchan.hashCode();
/*  690 */     _h_ += this.autopaychan.hashCode();
/*  691 */     _h_ += this.autopaysubchan.hashCode();
/*  692 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  698 */     _xdb_verify_unsafe_();
/*  699 */     StringBuilder _sb_ = new StringBuilder();
/*  700 */     _sb_.append("(");
/*  701 */     _sb_.append(this.first_buy_time);
/*  702 */     _sb_.append(",");
/*  703 */     _sb_.append(this.begin_time);
/*  704 */     _sb_.append(",");
/*  705 */     _sb_.append(this.end_time);
/*  706 */     _sb_.append(",");
/*  707 */     _sb_.append(this.grandtotal_opendays);
/*  708 */     _sb_.append(",");
/*  709 */     _sb_.append(this.grandtotal_presentdays);
/*  710 */     _sb_.append(",");
/*  711 */     _sb_.append("'").append(this.paychan).append("'");
/*  712 */     _sb_.append(",");
/*  713 */     _sb_.append("'").append(this.paysubchan).append("'");
/*  714 */     _sb_.append(",");
/*  715 */     _sb_.append("'").append(this.autopaychan).append("'");
/*  716 */     _sb_.append(",");
/*  717 */     _sb_.append("'").append(this.autopaysubchan).append("'");
/*  718 */     _sb_.append(")");
/*  719 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  725 */     ListenableBean lb = new ListenableBean();
/*  726 */     lb.add(new ListenableChanged().setVarName("first_buy_time"));
/*  727 */     lb.add(new ListenableChanged().setVarName("begin_time"));
/*  728 */     lb.add(new ListenableChanged().setVarName("end_time"));
/*  729 */     lb.add(new ListenableChanged().setVarName("grandtotal_opendays"));
/*  730 */     lb.add(new ListenableChanged().setVarName("grandtotal_presentdays"));
/*  731 */     lb.add(new ListenableChanged().setVarName("paychan"));
/*  732 */     lb.add(new ListenableChanged().setVarName("paysubchan"));
/*  733 */     lb.add(new ListenableChanged().setVarName("autopaychan"));
/*  734 */     lb.add(new ListenableChanged().setVarName("autopaysubchan"));
/*  735 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.TssSumInfo {
/*      */     private Const() {}
/*      */     
/*      */     TssSumInfo nThis() {
/*  742 */       return TssSumInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  748 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TssSumInfo copy()
/*      */     {
/*  754 */       return TssSumInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TssSumInfo toData()
/*      */     {
/*  760 */       return TssSumInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.TssSumInfo toBean()
/*      */     {
/*  765 */       return TssSumInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TssSumInfo toDataIf()
/*      */     {
/*  771 */       return TssSumInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.TssSumInfo toBeanIf()
/*      */     {
/*  776 */       return TssSumInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFirst_buy_time()
/*      */     {
/*  783 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  784 */       return TssSumInfo.this.first_buy_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBegin_time()
/*      */     {
/*  791 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  792 */       return TssSumInfo.this.begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEnd_time()
/*      */     {
/*  799 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  800 */       return TssSumInfo.this.end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGrandtotal_opendays()
/*      */     {
/*  807 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  808 */       return TssSumInfo.this.grandtotal_opendays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGrandtotal_presentdays()
/*      */     {
/*  815 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  816 */       return TssSumInfo.this.grandtotal_presentdays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getPaychan()
/*      */     {
/*  823 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  824 */       return TssSumInfo.this.paychan;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getPaychanOctets()
/*      */     {
/*  831 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  832 */       return TssSumInfo.this.getPaychanOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getPaysubchan()
/*      */     {
/*  839 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  840 */       return TssSumInfo.this.paysubchan;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getPaysubchanOctets()
/*      */     {
/*  847 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  848 */       return TssSumInfo.this.getPaysubchanOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getAutopaychan()
/*      */     {
/*  855 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  856 */       return TssSumInfo.this.autopaychan;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getAutopaychanOctets()
/*      */     {
/*  863 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  864 */       return TssSumInfo.this.getAutopaychanOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getAutopaysubchan()
/*      */     {
/*  871 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  872 */       return TssSumInfo.this.autopaysubchan;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getAutopaysubchanOctets()
/*      */     {
/*  879 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  880 */       return TssSumInfo.this.getAutopaysubchanOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFirst_buy_time(long _v_)
/*      */     {
/*  887 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  888 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBegin_time(long _v_)
/*      */     {
/*  895 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  896 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnd_time(long _v_)
/*      */     {
/*  903 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  904 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrandtotal_opendays(long _v_)
/*      */     {
/*  911 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  912 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrandtotal_presentdays(long _v_)
/*      */     {
/*  919 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  920 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPaychan(String _v_)
/*      */     {
/*  927 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  928 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPaychanOctets(Octets _v_)
/*      */     {
/*  935 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  936 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPaysubchan(String _v_)
/*      */     {
/*  943 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  944 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPaysubchanOctets(Octets _v_)
/*      */     {
/*  951 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  952 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAutopaychan(String _v_)
/*      */     {
/*  959 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  960 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAutopaychanOctets(Octets _v_)
/*      */     {
/*  967 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  968 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAutopaysubchan(String _v_)
/*      */     {
/*  975 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  976 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAutopaysubchanOctets(Octets _v_)
/*      */     {
/*  983 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  984 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  990 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  991 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  997 */       TssSumInfo.this._xdb_verify_unsafe_();
/*  998 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/* 1004 */       return TssSumInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1010 */       return TssSumInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1016 */       TssSumInfo.this._xdb_verify_unsafe_();
/* 1017 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/* 1023 */       return TssSumInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1029 */       return TssSumInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/* 1035 */       TssSumInfo.this._xdb_verify_unsafe_();
/* 1036 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/* 1042 */       return TssSumInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1048 */       return TssSumInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/* 1054 */       return TssSumInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/* 1060 */       return TssSumInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/* 1066 */       return TssSumInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/* 1072 */       return TssSumInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1078 */       return TssSumInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.TssSumInfo
/*      */   {
/*      */     private long first_buy_time;
/*      */     
/*      */     private long begin_time;
/*      */     
/*      */     private long end_time;
/*      */     
/*      */     private long grandtotal_opendays;
/*      */     
/*      */     private long grandtotal_presentdays;
/*      */     
/*      */     private String paychan;
/*      */     
/*      */     private String paysubchan;
/*      */     
/*      */     private String autopaychan;
/*      */     
/*      */     private String autopaysubchan;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1106 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1111 */       this.first_buy_time = 0L;
/* 1112 */       this.paychan = "";
/* 1113 */       this.paysubchan = "";
/* 1114 */       this.autopaychan = "";
/* 1115 */       this.autopaysubchan = "";
/*      */     }
/*      */     
/*      */     Data(xbean.TssSumInfo _o1_)
/*      */     {
/* 1120 */       if ((_o1_ instanceof TssSumInfo)) { assign((TssSumInfo)_o1_);
/* 1121 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1122 */       } else if ((_o1_ instanceof TssSumInfo.Const)) assign(((TssSumInfo.Const)_o1_).nThis()); else {
/* 1123 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(TssSumInfo _o_) {
/* 1128 */       this.first_buy_time = _o_.first_buy_time;
/* 1129 */       this.begin_time = _o_.begin_time;
/* 1130 */       this.end_time = _o_.end_time;
/* 1131 */       this.grandtotal_opendays = _o_.grandtotal_opendays;
/* 1132 */       this.grandtotal_presentdays = _o_.grandtotal_presentdays;
/* 1133 */       this.paychan = _o_.paychan;
/* 1134 */       this.paysubchan = _o_.paysubchan;
/* 1135 */       this.autopaychan = _o_.autopaychan;
/* 1136 */       this.autopaysubchan = _o_.autopaysubchan;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1141 */       this.first_buy_time = _o_.first_buy_time;
/* 1142 */       this.begin_time = _o_.begin_time;
/* 1143 */       this.end_time = _o_.end_time;
/* 1144 */       this.grandtotal_opendays = _o_.grandtotal_opendays;
/* 1145 */       this.grandtotal_presentdays = _o_.grandtotal_presentdays;
/* 1146 */       this.paychan = _o_.paychan;
/* 1147 */       this.paysubchan = _o_.paysubchan;
/* 1148 */       this.autopaychan = _o_.autopaychan;
/* 1149 */       this.autopaysubchan = _o_.autopaysubchan;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1155 */       _os_.marshal(this.first_buy_time);
/* 1156 */       _os_.marshal(this.begin_time);
/* 1157 */       _os_.marshal(this.end_time);
/* 1158 */       _os_.marshal(this.grandtotal_opendays);
/* 1159 */       _os_.marshal(this.grandtotal_presentdays);
/* 1160 */       _os_.marshal(this.paychan, "UTF-16LE");
/* 1161 */       _os_.marshal(this.paysubchan, "UTF-16LE");
/* 1162 */       _os_.marshal(this.autopaychan, "UTF-16LE");
/* 1163 */       _os_.marshal(this.autopaysubchan, "UTF-16LE");
/* 1164 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1170 */       this.first_buy_time = _os_.unmarshal_long();
/* 1171 */       this.begin_time = _os_.unmarshal_long();
/* 1172 */       this.end_time = _os_.unmarshal_long();
/* 1173 */       this.grandtotal_opendays = _os_.unmarshal_long();
/* 1174 */       this.grandtotal_presentdays = _os_.unmarshal_long();
/* 1175 */       this.paychan = _os_.unmarshal_String("UTF-16LE");
/* 1176 */       this.paysubchan = _os_.unmarshal_String("UTF-16LE");
/* 1177 */       this.autopaychan = _os_.unmarshal_String("UTF-16LE");
/* 1178 */       this.autopaysubchan = _os_.unmarshal_String("UTF-16LE");
/* 1179 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1185 */       int _size_ = 0;
/* 1186 */       _size_ += CodedOutputStream.computeInt64Size(1, this.first_buy_time);
/* 1187 */       _size_ += CodedOutputStream.computeInt64Size(2, this.begin_time);
/* 1188 */       _size_ += CodedOutputStream.computeInt64Size(3, this.end_time);
/* 1189 */       _size_ += CodedOutputStream.computeInt64Size(4, this.grandtotal_opendays);
/* 1190 */       _size_ += CodedOutputStream.computeInt64Size(5, this.grandtotal_presentdays);
/*      */       try
/*      */       {
/* 1193 */         _size_ += CodedOutputStream.computeBytesSize(6, ByteString.copyFrom(this.paychan, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1197 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 1201 */         _size_ += CodedOutputStream.computeBytesSize(7, ByteString.copyFrom(this.paysubchan, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1205 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 1209 */         _size_ += CodedOutputStream.computeBytesSize(8, ByteString.copyFrom(this.autopaychan, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1213 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 1217 */         _size_ += CodedOutputStream.computeBytesSize(9, ByteString.copyFrom(this.autopaysubchan, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1221 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1223 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1231 */         _output_.writeInt64(1, this.first_buy_time);
/* 1232 */         _output_.writeInt64(2, this.begin_time);
/* 1233 */         _output_.writeInt64(3, this.end_time);
/* 1234 */         _output_.writeInt64(4, this.grandtotal_opendays);
/* 1235 */         _output_.writeInt64(5, this.grandtotal_presentdays);
/* 1236 */         _output_.writeBytes(6, ByteString.copyFrom(this.paychan, "UTF-16LE"));
/* 1237 */         _output_.writeBytes(7, ByteString.copyFrom(this.paysubchan, "UTF-16LE"));
/* 1238 */         _output_.writeBytes(8, ByteString.copyFrom(this.autopaychan, "UTF-16LE"));
/* 1239 */         _output_.writeBytes(9, ByteString.copyFrom(this.autopaysubchan, "UTF-16LE"));
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1243 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1245 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1253 */         boolean done = false;
/* 1254 */         while (!done)
/*      */         {
/* 1256 */           int tag = _input_.readTag();
/* 1257 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1261 */             done = true;
/* 1262 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1266 */             this.first_buy_time = _input_.readInt64();
/* 1267 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1271 */             this.begin_time = _input_.readInt64();
/* 1272 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1276 */             this.end_time = _input_.readInt64();
/* 1277 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1281 */             this.grandtotal_opendays = _input_.readInt64();
/* 1282 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1286 */             this.grandtotal_presentdays = _input_.readInt64();
/* 1287 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/* 1291 */             this.paychan = _input_.readBytes().toString("UTF-16LE");
/* 1292 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1296 */             this.paysubchan = _input_.readBytes().toString("UTF-16LE");
/* 1297 */             break;
/*      */           
/*      */ 
/*      */           case 66: 
/* 1301 */             this.autopaychan = _input_.readBytes().toString("UTF-16LE");
/* 1302 */             break;
/*      */           
/*      */ 
/*      */           case 74: 
/* 1306 */             this.autopaysubchan = _input_.readBytes().toString("UTF-16LE");
/* 1307 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1311 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1313 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1322 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1326 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1328 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TssSumInfo copy()
/*      */     {
/* 1334 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TssSumInfo toData()
/*      */     {
/* 1340 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.TssSumInfo toBean()
/*      */     {
/* 1345 */       return new TssSumInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.TssSumInfo toDataIf()
/*      */     {
/* 1351 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.TssSumInfo toBeanIf()
/*      */     {
/* 1356 */       return new TssSumInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1362 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1366 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1370 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1374 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1378 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1382 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1386 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getFirst_buy_time()
/*      */     {
/* 1393 */       return this.first_buy_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBegin_time()
/*      */     {
/* 1400 */       return this.begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEnd_time()
/*      */     {
/* 1407 */       return this.end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGrandtotal_opendays()
/*      */     {
/* 1414 */       return this.grandtotal_opendays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getGrandtotal_presentdays()
/*      */     {
/* 1421 */       return this.grandtotal_presentdays;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getPaychan()
/*      */     {
/* 1428 */       return this.paychan;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getPaychanOctets()
/*      */     {
/* 1435 */       return Octets.wrap(getPaychan(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getPaysubchan()
/*      */     {
/* 1442 */       return this.paysubchan;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getPaysubchanOctets()
/*      */     {
/* 1449 */       return Octets.wrap(getPaysubchan(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getAutopaychan()
/*      */     {
/* 1456 */       return this.autopaychan;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getAutopaychanOctets()
/*      */     {
/* 1463 */       return Octets.wrap(getAutopaychan(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getAutopaysubchan()
/*      */     {
/* 1470 */       return this.autopaysubchan;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getAutopaysubchanOctets()
/*      */     {
/* 1477 */       return Octets.wrap(getAutopaysubchan(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setFirst_buy_time(long _v_)
/*      */     {
/* 1484 */       this.first_buy_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBegin_time(long _v_)
/*      */     {
/* 1491 */       this.begin_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnd_time(long _v_)
/*      */     {
/* 1498 */       this.end_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrandtotal_opendays(long _v_)
/*      */     {
/* 1505 */       this.grandtotal_opendays = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setGrandtotal_presentdays(long _v_)
/*      */     {
/* 1512 */       this.grandtotal_presentdays = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPaychan(String _v_)
/*      */     {
/* 1519 */       if (null == _v_)
/* 1520 */         throw new NullPointerException();
/* 1521 */       this.paychan = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPaychanOctets(Octets _v_)
/*      */     {
/* 1528 */       setPaychan(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPaysubchan(String _v_)
/*      */     {
/* 1535 */       if (null == _v_)
/* 1536 */         throw new NullPointerException();
/* 1537 */       this.paysubchan = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setPaysubchanOctets(Octets _v_)
/*      */     {
/* 1544 */       setPaysubchan(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAutopaychan(String _v_)
/*      */     {
/* 1551 */       if (null == _v_)
/* 1552 */         throw new NullPointerException();
/* 1553 */       this.autopaychan = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAutopaychanOctets(Octets _v_)
/*      */     {
/* 1560 */       setAutopaychan(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAutopaysubchan(String _v_)
/*      */     {
/* 1567 */       if (null == _v_)
/* 1568 */         throw new NullPointerException();
/* 1569 */       this.autopaysubchan = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setAutopaysubchanOctets(Octets _v_)
/*      */     {
/* 1576 */       setAutopaysubchan(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1582 */       if (!(_o1_ instanceof Data)) return false;
/* 1583 */       Data _o_ = (Data)_o1_;
/* 1584 */       if (this.first_buy_time != _o_.first_buy_time) return false;
/* 1585 */       if (this.begin_time != _o_.begin_time) return false;
/* 1586 */       if (this.end_time != _o_.end_time) return false;
/* 1587 */       if (this.grandtotal_opendays != _o_.grandtotal_opendays) return false;
/* 1588 */       if (this.grandtotal_presentdays != _o_.grandtotal_presentdays) return false;
/* 1589 */       if (!this.paychan.equals(_o_.paychan)) return false;
/* 1590 */       if (!this.paysubchan.equals(_o_.paysubchan)) return false;
/* 1591 */       if (!this.autopaychan.equals(_o_.autopaychan)) return false;
/* 1592 */       if (!this.autopaysubchan.equals(_o_.autopaysubchan)) return false;
/* 1593 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1599 */       int _h_ = 0;
/* 1600 */       _h_ = (int)(_h_ + this.first_buy_time);
/* 1601 */       _h_ = (int)(_h_ + this.begin_time);
/* 1602 */       _h_ = (int)(_h_ + this.end_time);
/* 1603 */       _h_ = (int)(_h_ + this.grandtotal_opendays);
/* 1604 */       _h_ = (int)(_h_ + this.grandtotal_presentdays);
/* 1605 */       _h_ += this.paychan.hashCode();
/* 1606 */       _h_ += this.paysubchan.hashCode();
/* 1607 */       _h_ += this.autopaychan.hashCode();
/* 1608 */       _h_ += this.autopaysubchan.hashCode();
/* 1609 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1615 */       StringBuilder _sb_ = new StringBuilder();
/* 1616 */       _sb_.append("(");
/* 1617 */       _sb_.append(this.first_buy_time);
/* 1618 */       _sb_.append(",");
/* 1619 */       _sb_.append(this.begin_time);
/* 1620 */       _sb_.append(",");
/* 1621 */       _sb_.append(this.end_time);
/* 1622 */       _sb_.append(",");
/* 1623 */       _sb_.append(this.grandtotal_opendays);
/* 1624 */       _sb_.append(",");
/* 1625 */       _sb_.append(this.grandtotal_presentdays);
/* 1626 */       _sb_.append(",");
/* 1627 */       _sb_.append("'").append(this.paychan).append("'");
/* 1628 */       _sb_.append(",");
/* 1629 */       _sb_.append("'").append(this.paysubchan).append("'");
/* 1630 */       _sb_.append(",");
/* 1631 */       _sb_.append("'").append(this.autopaychan).append("'");
/* 1632 */       _sb_.append(",");
/* 1633 */       _sb_.append("'").append(this.autopaysubchan).append("'");
/* 1634 */       _sb_.append(")");
/* 1635 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\TssSumInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */