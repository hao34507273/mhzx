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
/*      */ import xdb.logs.LogInt;
/*      */ import xdb.logs.LogLong;
/*      */ 
/*      */ public final class IdipMarqueeInfo extends XBean implements xbean.IdipMarqueeInfo
/*      */ {
/*      */   private long begin_time;
/*      */   private long end_time;
/*      */   private String mail_title;
/*      */   private String mail_content;
/*      */   private int rollfre;
/*      */   private int rollnum;
/*      */   private int real_num;
/*      */   private int version;
/*      */   private long indexid;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   34 */     this.begin_time = 0L;
/*   35 */     this.end_time = 0L;
/*   36 */     this.mail_title = "";
/*   37 */     this.mail_content = "";
/*   38 */     this.rollfre = 0;
/*   39 */     this.rollnum = 0;
/*   40 */     this.real_num = 0;
/*   41 */     this.version = 0;
/*   42 */     this.indexid = 0L;
/*      */   }
/*      */   
/*      */   IdipMarqueeInfo(int __, XBean _xp_, String _vn_)
/*      */   {
/*   47 */     super(_xp_, _vn_);
/*   48 */     this.mail_title = "";
/*   49 */     this.mail_content = "";
/*      */   }
/*      */   
/*      */   public IdipMarqueeInfo()
/*      */   {
/*   54 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public IdipMarqueeInfo(IdipMarqueeInfo _o_)
/*      */   {
/*   59 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   IdipMarqueeInfo(xbean.IdipMarqueeInfo _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   64 */     super(_xp_, _vn_);
/*   65 */     if ((_o1_ instanceof IdipMarqueeInfo)) { assign((IdipMarqueeInfo)_o1_);
/*   66 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   67 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   68 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(IdipMarqueeInfo _o_) {
/*   73 */     _o_._xdb_verify_unsafe_();
/*   74 */     this.begin_time = _o_.begin_time;
/*   75 */     this.end_time = _o_.end_time;
/*   76 */     this.mail_title = _o_.mail_title;
/*   77 */     this.mail_content = _o_.mail_content;
/*   78 */     this.rollfre = _o_.rollfre;
/*   79 */     this.rollnum = _o_.rollnum;
/*   80 */     this.real_num = _o_.real_num;
/*   81 */     this.version = _o_.version;
/*   82 */     this.indexid = _o_.indexid;
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   87 */     this.begin_time = _o_.begin_time;
/*   88 */     this.end_time = _o_.end_time;
/*   89 */     this.mail_title = _o_.mail_title;
/*   90 */     this.mail_content = _o_.mail_content;
/*   91 */     this.rollfre = _o_.rollfre;
/*   92 */     this.rollnum = _o_.rollnum;
/*   93 */     this.real_num = _o_.real_num;
/*   94 */     this.version = _o_.version;
/*   95 */     this.indexid = _o_.indexid;
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  101 */     _xdb_verify_unsafe_();
/*  102 */     _os_.marshal(this.begin_time);
/*  103 */     _os_.marshal(this.end_time);
/*  104 */     _os_.marshal(this.mail_title, "UTF-16LE");
/*  105 */     _os_.marshal(this.mail_content, "UTF-16LE");
/*  106 */     _os_.marshal(this.rollfre);
/*  107 */     _os_.marshal(this.rollnum);
/*  108 */     _os_.marshal(this.real_num);
/*  109 */     _os_.marshal(this.version);
/*  110 */     _os_.marshal(this.indexid);
/*  111 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  117 */     _xdb_verify_unsafe_();
/*  118 */     this.begin_time = _os_.unmarshal_long();
/*  119 */     this.end_time = _os_.unmarshal_long();
/*  120 */     this.mail_title = _os_.unmarshal_String("UTF-16LE");
/*  121 */     this.mail_content = _os_.unmarshal_String("UTF-16LE");
/*  122 */     this.rollfre = _os_.unmarshal_int();
/*  123 */     this.rollnum = _os_.unmarshal_int();
/*  124 */     this.real_num = _os_.unmarshal_int();
/*  125 */     this.version = _os_.unmarshal_int();
/*  126 */     this.indexid = _os_.unmarshal_long();
/*  127 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  133 */     _xdb_verify_unsafe_();
/*  134 */     int _size_ = 0;
/*  135 */     _size_ += CodedOutputStream.computeInt64Size(1, this.begin_time);
/*  136 */     _size_ += CodedOutputStream.computeInt64Size(2, this.end_time);
/*      */     try
/*      */     {
/*  139 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.mail_title, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  143 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  147 */       _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.mail_content, "UTF-16LE"));
/*      */     }
/*      */     catch (UnsupportedEncodingException e)
/*      */     {
/*  151 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  153 */     _size_ += CodedOutputStream.computeInt32Size(5, this.rollfre);
/*  154 */     _size_ += CodedOutputStream.computeInt32Size(6, this.rollnum);
/*  155 */     _size_ += CodedOutputStream.computeInt32Size(7, this.real_num);
/*  156 */     _size_ += CodedOutputStream.computeInt32Size(8, this.version);
/*  157 */     _size_ += CodedOutputStream.computeInt64Size(9, this.indexid);
/*  158 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  164 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  167 */       _output_.writeInt64(1, this.begin_time);
/*  168 */       _output_.writeInt64(2, this.end_time);
/*  169 */       _output_.writeBytes(3, ByteString.copyFrom(this.mail_title, "UTF-16LE"));
/*  170 */       _output_.writeBytes(4, ByteString.copyFrom(this.mail_content, "UTF-16LE"));
/*  171 */       _output_.writeInt32(5, this.rollfre);
/*  172 */       _output_.writeInt32(6, this.rollnum);
/*  173 */       _output_.writeInt32(7, this.real_num);
/*  174 */       _output_.writeInt32(8, this.version);
/*  175 */       _output_.writeInt64(9, this.indexid);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  179 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  181 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  187 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  190 */       boolean done = false;
/*  191 */       while (!done)
/*      */       {
/*  193 */         int tag = _input_.readTag();
/*  194 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  198 */           done = true;
/*  199 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  203 */           this.begin_time = _input_.readInt64();
/*  204 */           break;
/*      */         
/*      */ 
/*      */         case 16: 
/*  208 */           this.end_time = _input_.readInt64();
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  213 */           this.mail_title = _input_.readBytes().toString("UTF-16LE");
/*  214 */           break;
/*      */         
/*      */ 
/*      */         case 34: 
/*  218 */           this.mail_content = _input_.readBytes().toString("UTF-16LE");
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  223 */           this.rollfre = _input_.readInt32();
/*  224 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  228 */           this.rollnum = _input_.readInt32();
/*  229 */           break;
/*      */         
/*      */ 
/*      */         case 56: 
/*  233 */           this.real_num = _input_.readInt32();
/*  234 */           break;
/*      */         
/*      */ 
/*      */         case 64: 
/*  238 */           this.version = _input_.readInt32();
/*  239 */           break;
/*      */         
/*      */ 
/*      */         case 72: 
/*  243 */           this.indexid = _input_.readInt64();
/*  244 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  248 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  250 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  259 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  263 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  265 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IdipMarqueeInfo copy()
/*      */   {
/*  271 */     _xdb_verify_unsafe_();
/*  272 */     return new IdipMarqueeInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IdipMarqueeInfo toData()
/*      */   {
/*  278 */     _xdb_verify_unsafe_();
/*  279 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.IdipMarqueeInfo toBean()
/*      */   {
/*  284 */     _xdb_verify_unsafe_();
/*  285 */     return new IdipMarqueeInfo(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.IdipMarqueeInfo toDataIf()
/*      */   {
/*  291 */     _xdb_verify_unsafe_();
/*  292 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.IdipMarqueeInfo toBeanIf()
/*      */   {
/*  297 */     _xdb_verify_unsafe_();
/*  298 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  304 */     _xdb_verify_unsafe_();
/*  305 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getBegin_time()
/*      */   {
/*  312 */     _xdb_verify_unsafe_();
/*  313 */     return this.begin_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getEnd_time()
/*      */   {
/*  320 */     _xdb_verify_unsafe_();
/*  321 */     return this.end_time;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getMail_title()
/*      */   {
/*  328 */     _xdb_verify_unsafe_();
/*  329 */     return this.mail_title;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getMail_titleOctets()
/*      */   {
/*  336 */     _xdb_verify_unsafe_();
/*  337 */     return Octets.wrap(getMail_title(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getMail_content()
/*      */   {
/*  344 */     _xdb_verify_unsafe_();
/*  345 */     return this.mail_content;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getMail_contentOctets()
/*      */   {
/*  352 */     _xdb_verify_unsafe_();
/*  353 */     return Octets.wrap(getMail_content(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRollfre()
/*      */   {
/*  360 */     _xdb_verify_unsafe_();
/*  361 */     return this.rollfre;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getRollnum()
/*      */   {
/*  368 */     _xdb_verify_unsafe_();
/*  369 */     return this.rollnum;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getReal_num()
/*      */   {
/*  376 */     _xdb_verify_unsafe_();
/*  377 */     return this.real_num;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public int getVersion()
/*      */   {
/*  384 */     _xdb_verify_unsafe_();
/*  385 */     return this.version;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getIndexid()
/*      */   {
/*  392 */     _xdb_verify_unsafe_();
/*  393 */     return this.indexid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setBegin_time(long _v_)
/*      */   {
/*  400 */     _xdb_verify_unsafe_();
/*  401 */     Logs.logIf(new LogKey(this, "begin_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  405 */         new LogLong(this, IdipMarqueeInfo.this.begin_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  409 */             IdipMarqueeInfo.this.begin_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  413 */     });
/*  414 */     this.begin_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setEnd_time(long _v_)
/*      */   {
/*  421 */     _xdb_verify_unsafe_();
/*  422 */     Logs.logIf(new LogKey(this, "end_time")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  426 */         new LogLong(this, IdipMarqueeInfo.this.end_time)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  430 */             IdipMarqueeInfo.this.end_time = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  434 */     });
/*  435 */     this.end_time = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMail_title(String _v_)
/*      */   {
/*  442 */     _xdb_verify_unsafe_();
/*  443 */     if (null == _v_)
/*  444 */       throw new NullPointerException();
/*  445 */     Logs.logIf(new LogKey(this, "mail_title")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  449 */         new xdb.logs.LogString(this, IdipMarqueeInfo.this.mail_title)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  453 */             IdipMarqueeInfo.this.mail_title = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  457 */     });
/*  458 */     this.mail_title = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMail_titleOctets(Octets _v_)
/*      */   {
/*  465 */     _xdb_verify_unsafe_();
/*  466 */     setMail_title(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMail_content(String _v_)
/*      */   {
/*  473 */     _xdb_verify_unsafe_();
/*  474 */     if (null == _v_)
/*  475 */       throw new NullPointerException();
/*  476 */     Logs.logIf(new LogKey(this, "mail_content")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  480 */         new xdb.logs.LogString(this, IdipMarqueeInfo.this.mail_content)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  484 */             IdipMarqueeInfo.this.mail_content = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  488 */     });
/*  489 */     this.mail_content = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setMail_contentOctets(Octets _v_)
/*      */   {
/*  496 */     _xdb_verify_unsafe_();
/*  497 */     setMail_content(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRollfre(int _v_)
/*      */   {
/*  504 */     _xdb_verify_unsafe_();
/*  505 */     Logs.logIf(new LogKey(this, "rollfre")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  509 */         new LogInt(this, IdipMarqueeInfo.this.rollfre)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  513 */             IdipMarqueeInfo.this.rollfre = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  517 */     });
/*  518 */     this.rollfre = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRollnum(int _v_)
/*      */   {
/*  525 */     _xdb_verify_unsafe_();
/*  526 */     Logs.logIf(new LogKey(this, "rollnum")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  530 */         new LogInt(this, IdipMarqueeInfo.this.rollnum)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  534 */             IdipMarqueeInfo.this.rollnum = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  538 */     });
/*  539 */     this.rollnum = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setReal_num(int _v_)
/*      */   {
/*  546 */     _xdb_verify_unsafe_();
/*  547 */     Logs.logIf(new LogKey(this, "real_num")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  551 */         new LogInt(this, IdipMarqueeInfo.this.real_num)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  555 */             IdipMarqueeInfo.this.real_num = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  559 */     });
/*  560 */     this.real_num = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVersion(int _v_)
/*      */   {
/*  567 */     _xdb_verify_unsafe_();
/*  568 */     Logs.logIf(new LogKey(this, "version")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  572 */         new LogInt(this, IdipMarqueeInfo.this.version)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  576 */             IdipMarqueeInfo.this.version = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  580 */     });
/*  581 */     this.version = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setIndexid(long _v_)
/*      */   {
/*  588 */     _xdb_verify_unsafe_();
/*  589 */     Logs.logIf(new LogKey(this, "indexid")
/*      */     {
/*      */       protected Log create()
/*      */       {
/*  593 */         new LogLong(this, IdipMarqueeInfo.this.indexid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  597 */             IdipMarqueeInfo.this.indexid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  601 */     });
/*  602 */     this.indexid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  608 */     _xdb_verify_unsafe_();
/*  609 */     IdipMarqueeInfo _o_ = null;
/*  610 */     if ((_o1_ instanceof IdipMarqueeInfo)) { _o_ = (IdipMarqueeInfo)_o1_;
/*  611 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  612 */       return false;
/*  613 */     if (this.begin_time != _o_.begin_time) return false;
/*  614 */     if (this.end_time != _o_.end_time) return false;
/*  615 */     if (!this.mail_title.equals(_o_.mail_title)) return false;
/*  616 */     if (!this.mail_content.equals(_o_.mail_content)) return false;
/*  617 */     if (this.rollfre != _o_.rollfre) return false;
/*  618 */     if (this.rollnum != _o_.rollnum) return false;
/*  619 */     if (this.real_num != _o_.real_num) return false;
/*  620 */     if (this.version != _o_.version) return false;
/*  621 */     if (this.indexid != _o_.indexid) return false;
/*  622 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  628 */     _xdb_verify_unsafe_();
/*  629 */     int _h_ = 0;
/*  630 */     _h_ = (int)(_h_ + this.begin_time);
/*  631 */     _h_ = (int)(_h_ + this.end_time);
/*  632 */     _h_ += this.mail_title.hashCode();
/*  633 */     _h_ += this.mail_content.hashCode();
/*  634 */     _h_ += this.rollfre;
/*  635 */     _h_ += this.rollnum;
/*  636 */     _h_ += this.real_num;
/*  637 */     _h_ += this.version;
/*  638 */     _h_ = (int)(_h_ + this.indexid);
/*  639 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  645 */     _xdb_verify_unsafe_();
/*  646 */     StringBuilder _sb_ = new StringBuilder();
/*  647 */     _sb_.append("(");
/*  648 */     _sb_.append(this.begin_time);
/*  649 */     _sb_.append(",");
/*  650 */     _sb_.append(this.end_time);
/*  651 */     _sb_.append(",");
/*  652 */     _sb_.append("'").append(this.mail_title).append("'");
/*  653 */     _sb_.append(",");
/*  654 */     _sb_.append("'").append(this.mail_content).append("'");
/*  655 */     _sb_.append(",");
/*  656 */     _sb_.append(this.rollfre);
/*  657 */     _sb_.append(",");
/*  658 */     _sb_.append(this.rollnum);
/*  659 */     _sb_.append(",");
/*  660 */     _sb_.append(this.real_num);
/*  661 */     _sb_.append(",");
/*  662 */     _sb_.append(this.version);
/*  663 */     _sb_.append(",");
/*  664 */     _sb_.append(this.indexid);
/*  665 */     _sb_.append(")");
/*  666 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  672 */     ListenableBean lb = new ListenableBean();
/*  673 */     lb.add(new ListenableChanged().setVarName("begin_time"));
/*  674 */     lb.add(new ListenableChanged().setVarName("end_time"));
/*  675 */     lb.add(new ListenableChanged().setVarName("mail_title"));
/*  676 */     lb.add(new ListenableChanged().setVarName("mail_content"));
/*  677 */     lb.add(new ListenableChanged().setVarName("rollfre"));
/*  678 */     lb.add(new ListenableChanged().setVarName("rollnum"));
/*  679 */     lb.add(new ListenableChanged().setVarName("real_num"));
/*  680 */     lb.add(new ListenableChanged().setVarName("version"));
/*  681 */     lb.add(new ListenableChanged().setVarName("indexid"));
/*  682 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.IdipMarqueeInfo {
/*      */     private Const() {}
/*      */     
/*      */     IdipMarqueeInfo nThis() {
/*  689 */       return IdipMarqueeInfo.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  695 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipMarqueeInfo copy()
/*      */     {
/*  701 */       return IdipMarqueeInfo.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipMarqueeInfo toData()
/*      */     {
/*  707 */       return IdipMarqueeInfo.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.IdipMarqueeInfo toBean()
/*      */     {
/*  712 */       return IdipMarqueeInfo.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipMarqueeInfo toDataIf()
/*      */     {
/*  718 */       return IdipMarqueeInfo.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.IdipMarqueeInfo toBeanIf()
/*      */     {
/*  723 */       return IdipMarqueeInfo.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBegin_time()
/*      */     {
/*  730 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  731 */       return IdipMarqueeInfo.this.begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEnd_time()
/*      */     {
/*  738 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  739 */       return IdipMarqueeInfo.this.end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMail_title()
/*      */     {
/*  746 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  747 */       return IdipMarqueeInfo.this.mail_title;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMail_titleOctets()
/*      */     {
/*  754 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  755 */       return IdipMarqueeInfo.this.getMail_titleOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMail_content()
/*      */     {
/*  762 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  763 */       return IdipMarqueeInfo.this.mail_content;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMail_contentOctets()
/*      */     {
/*  770 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  771 */       return IdipMarqueeInfo.this.getMail_contentOctets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRollfre()
/*      */     {
/*  778 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  779 */       return IdipMarqueeInfo.this.rollfre;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRollnum()
/*      */     {
/*  786 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  787 */       return IdipMarqueeInfo.this.rollnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReal_num()
/*      */     {
/*  794 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  795 */       return IdipMarqueeInfo.this.real_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVersion()
/*      */     {
/*  802 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  803 */       return IdipMarqueeInfo.this.version;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getIndexid()
/*      */     {
/*  810 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  811 */       return IdipMarqueeInfo.this.indexid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBegin_time(long _v_)
/*      */     {
/*  818 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  819 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnd_time(long _v_)
/*      */     {
/*  826 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  827 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_title(String _v_)
/*      */     {
/*  834 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  835 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_titleOctets(Octets _v_)
/*      */     {
/*  842 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  843 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_content(String _v_)
/*      */     {
/*  850 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  851 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_contentOctets(Octets _v_)
/*      */     {
/*  858 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  859 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRollfre(int _v_)
/*      */     {
/*  866 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  867 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRollnum(int _v_)
/*      */     {
/*  874 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  875 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReal_num(int _v_)
/*      */     {
/*  882 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  883 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVersion(int _v_)
/*      */     {
/*  890 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  891 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIndexid(long _v_)
/*      */     {
/*  898 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  899 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  905 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  906 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  912 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  913 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  919 */       return IdipMarqueeInfo.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  925 */       return IdipMarqueeInfo.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  931 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  932 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  938 */       return IdipMarqueeInfo.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  944 */       return IdipMarqueeInfo.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  950 */       IdipMarqueeInfo.this._xdb_verify_unsafe_();
/*  951 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  957 */       return IdipMarqueeInfo.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  963 */       return IdipMarqueeInfo.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  969 */       return IdipMarqueeInfo.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  975 */       return IdipMarqueeInfo.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  981 */       return IdipMarqueeInfo.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  987 */       return IdipMarqueeInfo.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  993 */       return IdipMarqueeInfo.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.IdipMarqueeInfo
/*      */   {
/*      */     private long begin_time;
/*      */     
/*      */     private long end_time;
/*      */     
/*      */     private String mail_title;
/*      */     
/*      */     private String mail_content;
/*      */     
/*      */     private int rollfre;
/*      */     
/*      */     private int rollnum;
/*      */     
/*      */     private int real_num;
/*      */     
/*      */     private int version;
/*      */     
/*      */     private long indexid;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/* 1021 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/* 1026 */       this.mail_title = "";
/* 1027 */       this.mail_content = "";
/*      */     }
/*      */     
/*      */     Data(xbean.IdipMarqueeInfo _o1_)
/*      */     {
/* 1032 */       if ((_o1_ instanceof IdipMarqueeInfo)) { assign((IdipMarqueeInfo)_o1_);
/* 1033 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/* 1034 */       } else if ((_o1_ instanceof IdipMarqueeInfo.Const)) assign(((IdipMarqueeInfo.Const)_o1_).nThis()); else {
/* 1035 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(IdipMarqueeInfo _o_) {
/* 1040 */       this.begin_time = _o_.begin_time;
/* 1041 */       this.end_time = _o_.end_time;
/* 1042 */       this.mail_title = _o_.mail_title;
/* 1043 */       this.mail_content = _o_.mail_content;
/* 1044 */       this.rollfre = _o_.rollfre;
/* 1045 */       this.rollnum = _o_.rollnum;
/* 1046 */       this.real_num = _o_.real_num;
/* 1047 */       this.version = _o_.version;
/* 1048 */       this.indexid = _o_.indexid;
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/* 1053 */       this.begin_time = _o_.begin_time;
/* 1054 */       this.end_time = _o_.end_time;
/* 1055 */       this.mail_title = _o_.mail_title;
/* 1056 */       this.mail_content = _o_.mail_content;
/* 1057 */       this.rollfre = _o_.rollfre;
/* 1058 */       this.rollnum = _o_.rollnum;
/* 1059 */       this.real_num = _o_.real_num;
/* 1060 */       this.version = _o_.version;
/* 1061 */       this.indexid = _o_.indexid;
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/* 1067 */       _os_.marshal(this.begin_time);
/* 1068 */       _os_.marshal(this.end_time);
/* 1069 */       _os_.marshal(this.mail_title, "UTF-16LE");
/* 1070 */       _os_.marshal(this.mail_content, "UTF-16LE");
/* 1071 */       _os_.marshal(this.rollfre);
/* 1072 */       _os_.marshal(this.rollnum);
/* 1073 */       _os_.marshal(this.real_num);
/* 1074 */       _os_.marshal(this.version);
/* 1075 */       _os_.marshal(this.indexid);
/* 1076 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/* 1082 */       this.begin_time = _os_.unmarshal_long();
/* 1083 */       this.end_time = _os_.unmarshal_long();
/* 1084 */       this.mail_title = _os_.unmarshal_String("UTF-16LE");
/* 1085 */       this.mail_content = _os_.unmarshal_String("UTF-16LE");
/* 1086 */       this.rollfre = _os_.unmarshal_int();
/* 1087 */       this.rollnum = _os_.unmarshal_int();
/* 1088 */       this.real_num = _os_.unmarshal_int();
/* 1089 */       this.version = _os_.unmarshal_int();
/* 1090 */       this.indexid = _os_.unmarshal_long();
/* 1091 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/* 1097 */       int _size_ = 0;
/* 1098 */       _size_ += CodedOutputStream.computeInt64Size(1, this.begin_time);
/* 1099 */       _size_ += CodedOutputStream.computeInt64Size(2, this.end_time);
/*      */       try
/*      */       {
/* 1102 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.mail_title, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1106 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 1110 */         _size_ += CodedOutputStream.computeBytesSize(4, ByteString.copyFrom(this.mail_content, "UTF-16LE"));
/*      */       }
/*      */       catch (UnsupportedEncodingException e)
/*      */       {
/* 1114 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1116 */       _size_ += CodedOutputStream.computeInt32Size(5, this.rollfre);
/* 1117 */       _size_ += CodedOutputStream.computeInt32Size(6, this.rollnum);
/* 1118 */       _size_ += CodedOutputStream.computeInt32Size(7, this.real_num);
/* 1119 */       _size_ += CodedOutputStream.computeInt32Size(8, this.version);
/* 1120 */       _size_ += CodedOutputStream.computeInt64Size(9, this.indexid);
/* 1121 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1129 */         _output_.writeInt64(1, this.begin_time);
/* 1130 */         _output_.writeInt64(2, this.end_time);
/* 1131 */         _output_.writeBytes(3, ByteString.copyFrom(this.mail_title, "UTF-16LE"));
/* 1132 */         _output_.writeBytes(4, ByteString.copyFrom(this.mail_content, "UTF-16LE"));
/* 1133 */         _output_.writeInt32(5, this.rollfre);
/* 1134 */         _output_.writeInt32(6, this.rollnum);
/* 1135 */         _output_.writeInt32(7, this.real_num);
/* 1136 */         _output_.writeInt32(8, this.version);
/* 1137 */         _output_.writeInt64(9, this.indexid);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1141 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1143 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1151 */         boolean done = false;
/* 1152 */         while (!done)
/*      */         {
/* 1154 */           int tag = _input_.readTag();
/* 1155 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1159 */             done = true;
/* 1160 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1164 */             this.begin_time = _input_.readInt64();
/* 1165 */             break;
/*      */           
/*      */ 
/*      */           case 16: 
/* 1169 */             this.end_time = _input_.readInt64();
/* 1170 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/* 1174 */             this.mail_title = _input_.readBytes().toString("UTF-16LE");
/* 1175 */             break;
/*      */           
/*      */ 
/*      */           case 34: 
/* 1179 */             this.mail_content = _input_.readBytes().toString("UTF-16LE");
/* 1180 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1184 */             this.rollfre = _input_.readInt32();
/* 1185 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1189 */             this.rollnum = _input_.readInt32();
/* 1190 */             break;
/*      */           
/*      */ 
/*      */           case 56: 
/* 1194 */             this.real_num = _input_.readInt32();
/* 1195 */             break;
/*      */           
/*      */ 
/*      */           case 64: 
/* 1199 */             this.version = _input_.readInt32();
/* 1200 */             break;
/*      */           
/*      */ 
/*      */           case 72: 
/* 1204 */             this.indexid = _input_.readInt64();
/* 1205 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1209 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1211 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1220 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1224 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1226 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipMarqueeInfo copy()
/*      */     {
/* 1232 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipMarqueeInfo toData()
/*      */     {
/* 1238 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.IdipMarqueeInfo toBean()
/*      */     {
/* 1243 */       return new IdipMarqueeInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.IdipMarqueeInfo toDataIf()
/*      */     {
/* 1249 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.IdipMarqueeInfo toBeanIf()
/*      */     {
/* 1254 */       return new IdipMarqueeInfo(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1260 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1264 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1268 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1272 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1276 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1280 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1284 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getBegin_time()
/*      */     {
/* 1291 */       return this.begin_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getEnd_time()
/*      */     {
/* 1298 */       return this.end_time;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMail_title()
/*      */     {
/* 1305 */       return this.mail_title;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMail_titleOctets()
/*      */     {
/* 1312 */       return Octets.wrap(getMail_title(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getMail_content()
/*      */     {
/* 1319 */       return this.mail_content;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getMail_contentOctets()
/*      */     {
/* 1326 */       return Octets.wrap(getMail_content(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRollfre()
/*      */     {
/* 1333 */       return this.rollfre;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getRollnum()
/*      */     {
/* 1340 */       return this.rollnum;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getReal_num()
/*      */     {
/* 1347 */       return this.real_num;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public int getVersion()
/*      */     {
/* 1354 */       return this.version;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getIndexid()
/*      */     {
/* 1361 */       return this.indexid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setBegin_time(long _v_)
/*      */     {
/* 1368 */       this.begin_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setEnd_time(long _v_)
/*      */     {
/* 1375 */       this.end_time = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_title(String _v_)
/*      */     {
/* 1382 */       if (null == _v_)
/* 1383 */         throw new NullPointerException();
/* 1384 */       this.mail_title = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_titleOctets(Octets _v_)
/*      */     {
/* 1391 */       setMail_title(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_content(String _v_)
/*      */     {
/* 1398 */       if (null == _v_)
/* 1399 */         throw new NullPointerException();
/* 1400 */       this.mail_content = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setMail_contentOctets(Octets _v_)
/*      */     {
/* 1407 */       setMail_content(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRollfre(int _v_)
/*      */     {
/* 1414 */       this.rollfre = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRollnum(int _v_)
/*      */     {
/* 1421 */       this.rollnum = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setReal_num(int _v_)
/*      */     {
/* 1428 */       this.real_num = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVersion(int _v_)
/*      */     {
/* 1435 */       this.version = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setIndexid(long _v_)
/*      */     {
/* 1442 */       this.indexid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1448 */       if (!(_o1_ instanceof Data)) return false;
/* 1449 */       Data _o_ = (Data)_o1_;
/* 1450 */       if (this.begin_time != _o_.begin_time) return false;
/* 1451 */       if (this.end_time != _o_.end_time) return false;
/* 1452 */       if (!this.mail_title.equals(_o_.mail_title)) return false;
/* 1453 */       if (!this.mail_content.equals(_o_.mail_content)) return false;
/* 1454 */       if (this.rollfre != _o_.rollfre) return false;
/* 1455 */       if (this.rollnum != _o_.rollnum) return false;
/* 1456 */       if (this.real_num != _o_.real_num) return false;
/* 1457 */       if (this.version != _o_.version) return false;
/* 1458 */       if (this.indexid != _o_.indexid) return false;
/* 1459 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1465 */       int _h_ = 0;
/* 1466 */       _h_ = (int)(_h_ + this.begin_time);
/* 1467 */       _h_ = (int)(_h_ + this.end_time);
/* 1468 */       _h_ += this.mail_title.hashCode();
/* 1469 */       _h_ += this.mail_content.hashCode();
/* 1470 */       _h_ += this.rollfre;
/* 1471 */       _h_ += this.rollnum;
/* 1472 */       _h_ += this.real_num;
/* 1473 */       _h_ += this.version;
/* 1474 */       _h_ = (int)(_h_ + this.indexid);
/* 1475 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1481 */       StringBuilder _sb_ = new StringBuilder();
/* 1482 */       _sb_.append("(");
/* 1483 */       _sb_.append(this.begin_time);
/* 1484 */       _sb_.append(",");
/* 1485 */       _sb_.append(this.end_time);
/* 1486 */       _sb_.append(",");
/* 1487 */       _sb_.append("'").append(this.mail_title).append("'");
/* 1488 */       _sb_.append(",");
/* 1489 */       _sb_.append("'").append(this.mail_content).append("'");
/* 1490 */       _sb_.append(",");
/* 1491 */       _sb_.append(this.rollfre);
/* 1492 */       _sb_.append(",");
/* 1493 */       _sb_.append(this.rollnum);
/* 1494 */       _sb_.append(",");
/* 1495 */       _sb_.append(this.real_num);
/* 1496 */       _sb_.append(",");
/* 1497 */       _sb_.append(this.version);
/* 1498 */       _sb_.append(",");
/* 1499 */       _sb_.append(this.indexid);
/* 1500 */       _sb_.append(")");
/* 1501 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\IdipMarqueeInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */