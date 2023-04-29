/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class SwornNewName extends XBean implements xbean.SwornNewName
/*      */ {
/*      */   private long roleid;
/*      */   private String name1;
/*      */   private String name2;
/*      */   private long verifytime;
/*      */   private ArrayList<Long> verifyids;
/*      */   private ArrayList<Long> voteids;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   28 */     this.roleid = 0L;
/*   29 */     this.name1 = "";
/*   30 */     this.name2 = "";
/*   31 */     this.verifytime = 0L;
/*   32 */     this.verifyids.clear();
/*   33 */     this.voteids.clear();
/*      */   }
/*      */   
/*      */   SwornNewName(int __, XBean _xp_, String _vn_)
/*      */   {
/*   38 */     super(_xp_, _vn_);
/*   39 */     this.name1 = "";
/*   40 */     this.name2 = "";
/*   41 */     this.verifytime = 0L;
/*   42 */     this.verifyids = new ArrayList();
/*   43 */     this.voteids = new ArrayList();
/*      */   }
/*      */   
/*      */   public SwornNewName()
/*      */   {
/*   48 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public SwornNewName(SwornNewName _o_)
/*      */   {
/*   53 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   SwornNewName(xbean.SwornNewName _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   58 */     super(_xp_, _vn_);
/*   59 */     if ((_o1_ instanceof SwornNewName)) { assign((SwornNewName)_o1_);
/*   60 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   61 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   62 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(SwornNewName _o_) {
/*   67 */     _o_._xdb_verify_unsafe_();
/*   68 */     this.roleid = _o_.roleid;
/*   69 */     this.name1 = _o_.name1;
/*   70 */     this.name2 = _o_.name2;
/*   71 */     this.verifytime = _o_.verifytime;
/*   72 */     this.verifyids = new ArrayList();
/*   73 */     this.verifyids.addAll(_o_.verifyids);
/*   74 */     this.voteids = new ArrayList();
/*   75 */     this.voteids.addAll(_o_.voteids);
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   80 */     this.roleid = _o_.roleid;
/*   81 */     this.name1 = _o_.name1;
/*   82 */     this.name2 = _o_.name2;
/*   83 */     this.verifytime = _o_.verifytime;
/*   84 */     this.verifyids = new ArrayList();
/*   85 */     this.verifyids.addAll(_o_.verifyids);
/*   86 */     this.voteids = new ArrayList();
/*   87 */     this.voteids.addAll(_o_.voteids);
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*   93 */     _xdb_verify_unsafe_();
/*   94 */     _os_.marshal(this.roleid);
/*   95 */     _os_.marshal(this.name1, "UTF-16LE");
/*   96 */     _os_.marshal(this.name2, "UTF-16LE");
/*   97 */     _os_.marshal(this.verifytime);
/*   98 */     _os_.compact_uint32(this.verifyids.size());
/*   99 */     for (Long _v_ : this.verifyids)
/*      */     {
/*  101 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  103 */     _os_.compact_uint32(this.voteids.size());
/*  104 */     for (Long _v_ : this.voteids)
/*      */     {
/*  106 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  108 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  114 */     _xdb_verify_unsafe_();
/*  115 */     this.roleid = _os_.unmarshal_long();
/*  116 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/*  117 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/*  118 */     this.verifytime = _os_.unmarshal_long();
/*  119 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  121 */       long _v_ = 0L;
/*  122 */       _v_ = _os_.unmarshal_long();
/*  123 */       this.verifyids.add(Long.valueOf(_v_));
/*      */     }
/*  125 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  127 */       long _v_ = 0L;
/*  128 */       _v_ = _os_.unmarshal_long();
/*  129 */       this.voteids.add(Long.valueOf(_v_));
/*      */     }
/*  131 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  137 */     _xdb_verify_unsafe_();
/*  138 */     int _size_ = 0;
/*  139 */     _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*      */     try
/*      */     {
/*  142 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.name1, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  146 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  150 */       _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.name2, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  154 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  156 */     _size_ += CodedOutputStream.computeInt64Size(4, this.verifytime);
/*  157 */     for (Long _v_ : this.verifyids)
/*      */     {
/*  159 */       _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */     }
/*  161 */     for (Long _v_ : this.voteids)
/*      */     {
/*  163 */       _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */     }
/*  165 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  171 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  174 */       _output_.writeInt64(1, this.roleid);
/*  175 */       _output_.writeBytes(2, ByteString.copyFrom(this.name1, "UTF-16LE"));
/*  176 */       _output_.writeBytes(3, ByteString.copyFrom(this.name2, "UTF-16LE"));
/*  177 */       _output_.writeInt64(4, this.verifytime);
/*  178 */       for (Long _v_ : this.verifyids)
/*      */       {
/*  180 */         _output_.writeInt64(5, _v_.longValue());
/*      */       }
/*  182 */       for (Long _v_ : this.voteids)
/*      */       {
/*  184 */         _output_.writeInt64(6, _v_.longValue());
/*      */       }
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  189 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  191 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  197 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  200 */       boolean done = false;
/*  201 */       while (!done)
/*      */       {
/*  203 */         int tag = _input_.readTag();
/*  204 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  208 */           done = true;
/*  209 */           break;
/*      */         
/*      */ 
/*      */         case 8: 
/*  213 */           this.roleid = _input_.readInt64();
/*  214 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  218 */           this.name1 = _input_.readBytes().toString("UTF-16LE");
/*  219 */           break;
/*      */         
/*      */ 
/*      */         case 26: 
/*  223 */           this.name2 = _input_.readBytes().toString("UTF-16LE");
/*  224 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  228 */           this.verifytime = _input_.readInt64();
/*  229 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  233 */           long _v_ = 0L;
/*  234 */           _v_ = _input_.readInt64();
/*  235 */           this.verifyids.add(Long.valueOf(_v_));
/*  236 */           break;
/*      */         
/*      */ 
/*      */         case 48: 
/*  240 */           long _v_ = 0L;
/*  241 */           _v_ = _input_.readInt64();
/*  242 */           this.voteids.add(Long.valueOf(_v_));
/*  243 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  247 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  249 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  258 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (IOException e)
/*      */     {
/*  262 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  264 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornNewName copy()
/*      */   {
/*  270 */     _xdb_verify_unsafe_();
/*  271 */     return new SwornNewName(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornNewName toData()
/*      */   {
/*  277 */     _xdb_verify_unsafe_();
/*  278 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SwornNewName toBean()
/*      */   {
/*  283 */     _xdb_verify_unsafe_();
/*  284 */     return new SwornNewName(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.SwornNewName toDataIf()
/*      */   {
/*  290 */     _xdb_verify_unsafe_();
/*  291 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.SwornNewName toBeanIf()
/*      */   {
/*  296 */     _xdb_verify_unsafe_();
/*  297 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  303 */     _xdb_verify_unsafe_();
/*  304 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getRoleid()
/*      */   {
/*  311 */     _xdb_verify_unsafe_();
/*  312 */     return this.roleid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName1()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return this.name1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getName1Octets()
/*      */   {
/*  327 */     _xdb_verify_unsafe_();
/*  328 */     return Octets.wrap(getName1(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName2()
/*      */   {
/*  335 */     _xdb_verify_unsafe_();
/*  336 */     return this.name2;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getName2Octets()
/*      */   {
/*  343 */     _xdb_verify_unsafe_();
/*  344 */     return Octets.wrap(getName2(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getVerifytime()
/*      */   {
/*  351 */     _xdb_verify_unsafe_();
/*  352 */     return this.verifytime;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getVerifyids()
/*      */   {
/*  359 */     _xdb_verify_unsafe_();
/*  360 */     return xdb.Logs.logList(new LogKey(this, "verifyids"), this.verifyids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getVerifyidsAsData()
/*      */   {
/*  366 */     _xdb_verify_unsafe_();
/*      */     
/*  368 */     SwornNewName _o_ = this;
/*  369 */     List<Long> verifyids = new ArrayList();
/*  370 */     verifyids.addAll(_o_.verifyids);
/*  371 */     return verifyids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getVoteids()
/*      */   {
/*  378 */     _xdb_verify_unsafe_();
/*  379 */     return xdb.Logs.logList(new LogKey(this, "voteids"), this.voteids);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getVoteidsAsData()
/*      */   {
/*  385 */     _xdb_verify_unsafe_();
/*      */     
/*  387 */     SwornNewName _o_ = this;
/*  388 */     List<Long> voteids = new ArrayList();
/*  389 */     voteids.addAll(_o_.voteids);
/*  390 */     return voteids;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setRoleid(long _v_)
/*      */   {
/*  397 */     _xdb_verify_unsafe_();
/*  398 */     xdb.Logs.logIf(new LogKey(this, "roleid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  402 */         new xdb.logs.LogLong(this, SwornNewName.this.roleid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  406 */             SwornNewName.this.roleid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  410 */     });
/*  411 */     this.roleid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName1(String _v_)
/*      */   {
/*  418 */     _xdb_verify_unsafe_();
/*  419 */     if (null == _v_)
/*  420 */       throw new NullPointerException();
/*  421 */     xdb.Logs.logIf(new LogKey(this, "name1")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  425 */         new xdb.logs.LogString(this, SwornNewName.this.name1)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  429 */             SwornNewName.this.name1 = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  433 */     });
/*  434 */     this.name1 = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName1Octets(Octets _v_)
/*      */   {
/*  441 */     _xdb_verify_unsafe_();
/*  442 */     setName1(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName2(String _v_)
/*      */   {
/*  449 */     _xdb_verify_unsafe_();
/*  450 */     if (null == _v_)
/*  451 */       throw new NullPointerException();
/*  452 */     xdb.Logs.logIf(new LogKey(this, "name2")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  456 */         new xdb.logs.LogString(this, SwornNewName.this.name2)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  460 */             SwornNewName.this.name2 = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  464 */     });
/*  465 */     this.name2 = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName2Octets(Octets _v_)
/*      */   {
/*  472 */     _xdb_verify_unsafe_();
/*  473 */     setName2(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setVerifytime(long _v_)
/*      */   {
/*  480 */     _xdb_verify_unsafe_();
/*  481 */     xdb.Logs.logIf(new LogKey(this, "verifytime")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  485 */         new xdb.logs.LogLong(this, SwornNewName.this.verifytime)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  489 */             SwornNewName.this.verifytime = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  493 */     });
/*  494 */     this.verifytime = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  500 */     _xdb_verify_unsafe_();
/*  501 */     SwornNewName _o_ = null;
/*  502 */     if ((_o1_ instanceof SwornNewName)) { _o_ = (SwornNewName)_o1_;
/*  503 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  504 */       return false;
/*  505 */     if (this.roleid != _o_.roleid) return false;
/*  506 */     if (!this.name1.equals(_o_.name1)) return false;
/*  507 */     if (!this.name2.equals(_o_.name2)) return false;
/*  508 */     if (this.verifytime != _o_.verifytime) return false;
/*  509 */     if (!this.verifyids.equals(_o_.verifyids)) return false;
/*  510 */     if (!this.voteids.equals(_o_.voteids)) return false;
/*  511 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  517 */     _xdb_verify_unsafe_();
/*  518 */     int _h_ = 0;
/*  519 */     _h_ = (int)(_h_ + this.roleid);
/*  520 */     _h_ += this.name1.hashCode();
/*  521 */     _h_ += this.name2.hashCode();
/*  522 */     _h_ = (int)(_h_ + this.verifytime);
/*  523 */     _h_ += this.verifyids.hashCode();
/*  524 */     _h_ += this.voteids.hashCode();
/*  525 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  531 */     _xdb_verify_unsafe_();
/*  532 */     StringBuilder _sb_ = new StringBuilder();
/*  533 */     _sb_.append("(");
/*  534 */     _sb_.append(this.roleid);
/*  535 */     _sb_.append(",");
/*  536 */     _sb_.append("'").append(this.name1).append("'");
/*  537 */     _sb_.append(",");
/*  538 */     _sb_.append("'").append(this.name2).append("'");
/*  539 */     _sb_.append(",");
/*  540 */     _sb_.append(this.verifytime);
/*  541 */     _sb_.append(",");
/*  542 */     _sb_.append(this.verifyids);
/*  543 */     _sb_.append(",");
/*  544 */     _sb_.append(this.voteids);
/*  545 */     _sb_.append(")");
/*  546 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  552 */     ListenableBean lb = new ListenableBean();
/*  553 */     lb.add(new ListenableChanged().setVarName("roleid"));
/*  554 */     lb.add(new ListenableChanged().setVarName("name1"));
/*  555 */     lb.add(new ListenableChanged().setVarName("name2"));
/*  556 */     lb.add(new ListenableChanged().setVarName("verifytime"));
/*  557 */     lb.add(new ListenableChanged().setVarName("verifyids"));
/*  558 */     lb.add(new ListenableChanged().setVarName("voteids"));
/*  559 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.SwornNewName {
/*      */     private Const() {}
/*      */     
/*      */     SwornNewName nThis() {
/*  566 */       return SwornNewName.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  572 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewName copy()
/*      */     {
/*  578 */       return SwornNewName.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewName toData()
/*      */     {
/*  584 */       return SwornNewName.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.SwornNewName toBean()
/*      */     {
/*  589 */       return SwornNewName.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewName toDataIf()
/*      */     {
/*  595 */       return SwornNewName.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.SwornNewName toBeanIf()
/*      */     {
/*  600 */       return SwornNewName.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/*  607 */       SwornNewName.this._xdb_verify_unsafe_();
/*  608 */       return SwornNewName.this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName1()
/*      */     {
/*  615 */       SwornNewName.this._xdb_verify_unsafe_();
/*  616 */       return SwornNewName.this.name1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName1Octets()
/*      */     {
/*  623 */       SwornNewName.this._xdb_verify_unsafe_();
/*  624 */       return SwornNewName.this.getName1Octets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName2()
/*      */     {
/*  631 */       SwornNewName.this._xdb_verify_unsafe_();
/*  632 */       return SwornNewName.this.name2;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName2Octets()
/*      */     {
/*  639 */       SwornNewName.this._xdb_verify_unsafe_();
/*  640 */       return SwornNewName.this.getName2Octets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getVerifytime()
/*      */     {
/*  647 */       SwornNewName.this._xdb_verify_unsafe_();
/*  648 */       return SwornNewName.this.verifytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVerifyids()
/*      */     {
/*  655 */       SwornNewName.this._xdb_verify_unsafe_();
/*  656 */       return xdb.Consts.constList(SwornNewName.this.verifyids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getVerifyidsAsData()
/*      */     {
/*  662 */       SwornNewName.this._xdb_verify_unsafe_();
/*      */       
/*  664 */       SwornNewName _o_ = SwornNewName.this;
/*  665 */       List<Long> verifyids = new ArrayList();
/*  666 */       verifyids.addAll(_o_.verifyids);
/*  667 */       return verifyids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVoteids()
/*      */     {
/*  674 */       SwornNewName.this._xdb_verify_unsafe_();
/*  675 */       return xdb.Consts.constList(SwornNewName.this.voteids);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getVoteidsAsData()
/*      */     {
/*  681 */       SwornNewName.this._xdb_verify_unsafe_();
/*      */       
/*  683 */       SwornNewName _o_ = SwornNewName.this;
/*  684 */       List<Long> voteids = new ArrayList();
/*  685 */       voteids.addAll(_o_.voteids);
/*  686 */       return voteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/*  693 */       SwornNewName.this._xdb_verify_unsafe_();
/*  694 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1(String _v_)
/*      */     {
/*  701 */       SwornNewName.this._xdb_verify_unsafe_();
/*  702 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1Octets(Octets _v_)
/*      */     {
/*  709 */       SwornNewName.this._xdb_verify_unsafe_();
/*  710 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2(String _v_)
/*      */     {
/*  717 */       SwornNewName.this._xdb_verify_unsafe_();
/*  718 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2Octets(Octets _v_)
/*      */     {
/*  725 */       SwornNewName.this._xdb_verify_unsafe_();
/*  726 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVerifytime(long _v_)
/*      */     {
/*  733 */       SwornNewName.this._xdb_verify_unsafe_();
/*  734 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  740 */       SwornNewName.this._xdb_verify_unsafe_();
/*  741 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  747 */       SwornNewName.this._xdb_verify_unsafe_();
/*  748 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  754 */       return SwornNewName.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  760 */       return SwornNewName.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  766 */       SwornNewName.this._xdb_verify_unsafe_();
/*  767 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  773 */       return SwornNewName.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  779 */       return SwornNewName.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  785 */       SwornNewName.this._xdb_verify_unsafe_();
/*  786 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  792 */       return SwornNewName.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  798 */       return SwornNewName.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  804 */       return SwornNewName.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  810 */       return SwornNewName.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  816 */       return SwornNewName.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  822 */       return SwornNewName.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  828 */       return SwornNewName.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.SwornNewName
/*      */   {
/*      */     private long roleid;
/*      */     
/*      */     private String name1;
/*      */     
/*      */     private String name2;
/*      */     
/*      */     private long verifytime;
/*      */     
/*      */     private ArrayList<Long> verifyids;
/*      */     
/*      */     private ArrayList<Long> voteids;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  850 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  855 */       this.name1 = "";
/*  856 */       this.name2 = "";
/*  857 */       this.verifytime = 0L;
/*  858 */       this.verifyids = new ArrayList();
/*  859 */       this.voteids = new ArrayList();
/*      */     }
/*      */     
/*      */     Data(xbean.SwornNewName _o1_)
/*      */     {
/*  864 */       if ((_o1_ instanceof SwornNewName)) { assign((SwornNewName)_o1_);
/*  865 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  866 */       } else if ((_o1_ instanceof SwornNewName.Const)) assign(((SwornNewName.Const)_o1_).nThis()); else {
/*  867 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(SwornNewName _o_) {
/*  872 */       this.roleid = _o_.roleid;
/*  873 */       this.name1 = _o_.name1;
/*  874 */       this.name2 = _o_.name2;
/*  875 */       this.verifytime = _o_.verifytime;
/*  876 */       this.verifyids = new ArrayList();
/*  877 */       this.verifyids.addAll(_o_.verifyids);
/*  878 */       this.voteids = new ArrayList();
/*  879 */       this.voteids.addAll(_o_.voteids);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  884 */       this.roleid = _o_.roleid;
/*  885 */       this.name1 = _o_.name1;
/*  886 */       this.name2 = _o_.name2;
/*  887 */       this.verifytime = _o_.verifytime;
/*  888 */       this.verifyids = new ArrayList();
/*  889 */       this.verifyids.addAll(_o_.verifyids);
/*  890 */       this.voteids = new ArrayList();
/*  891 */       this.voteids.addAll(_o_.voteids);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  897 */       _os_.marshal(this.roleid);
/*  898 */       _os_.marshal(this.name1, "UTF-16LE");
/*  899 */       _os_.marshal(this.name2, "UTF-16LE");
/*  900 */       _os_.marshal(this.verifytime);
/*  901 */       _os_.compact_uint32(this.verifyids.size());
/*  902 */       for (Long _v_ : this.verifyids)
/*      */       {
/*  904 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  906 */       _os_.compact_uint32(this.voteids.size());
/*  907 */       for (Long _v_ : this.voteids)
/*      */       {
/*  909 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  911 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  917 */       this.roleid = _os_.unmarshal_long();
/*  918 */       this.name1 = _os_.unmarshal_String("UTF-16LE");
/*  919 */       this.name2 = _os_.unmarshal_String("UTF-16LE");
/*  920 */       this.verifytime = _os_.unmarshal_long();
/*  921 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  923 */         long _v_ = 0L;
/*  924 */         _v_ = _os_.unmarshal_long();
/*  925 */         this.verifyids.add(Long.valueOf(_v_));
/*      */       }
/*  927 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  929 */         long _v_ = 0L;
/*  930 */         _v_ = _os_.unmarshal_long();
/*  931 */         this.voteids.add(Long.valueOf(_v_));
/*      */       }
/*  933 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  939 */       int _size_ = 0;
/*  940 */       _size_ += CodedOutputStream.computeInt64Size(1, this.roleid);
/*      */       try
/*      */       {
/*  943 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.name1, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  947 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/*  951 */         _size_ += CodedOutputStream.computeBytesSize(3, ByteString.copyFrom(this.name2, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  955 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*  957 */       _size_ += CodedOutputStream.computeInt64Size(4, this.verifytime);
/*  958 */       for (Long _v_ : this.verifyids)
/*      */       {
/*  960 */         _size_ += CodedOutputStream.computeInt64Size(5, _v_.longValue());
/*      */       }
/*  962 */       for (Long _v_ : this.voteids)
/*      */       {
/*  964 */         _size_ += CodedOutputStream.computeInt64Size(6, _v_.longValue());
/*      */       }
/*  966 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  974 */         _output_.writeInt64(1, this.roleid);
/*  975 */         _output_.writeBytes(2, ByteString.copyFrom(this.name1, "UTF-16LE"));
/*  976 */         _output_.writeBytes(3, ByteString.copyFrom(this.name2, "UTF-16LE"));
/*  977 */         _output_.writeInt64(4, this.verifytime);
/*  978 */         for (Long _v_ : this.verifyids)
/*      */         {
/*  980 */           _output_.writeInt64(5, _v_.longValue());
/*      */         }
/*  982 */         for (Long _v_ : this.voteids)
/*      */         {
/*  984 */           _output_.writeInt64(6, _v_.longValue());
/*      */         }
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/*  989 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/*  991 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/*  999 */         boolean done = false;
/* 1000 */         while (!done)
/*      */         {
/* 1002 */           int tag = _input_.readTag();
/* 1003 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1007 */             done = true;
/* 1008 */             break;
/*      */           
/*      */ 
/*      */           case 8: 
/* 1012 */             this.roleid = _input_.readInt64();
/* 1013 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/* 1017 */             this.name1 = _input_.readBytes().toString("UTF-16LE");
/* 1018 */             break;
/*      */           
/*      */ 
/*      */           case 26: 
/* 1022 */             this.name2 = _input_.readBytes().toString("UTF-16LE");
/* 1023 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1027 */             this.verifytime = _input_.readInt64();
/* 1028 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1032 */             long _v_ = 0L;
/* 1033 */             _v_ = _input_.readInt64();
/* 1034 */             this.verifyids.add(Long.valueOf(_v_));
/* 1035 */             break;
/*      */           
/*      */ 
/*      */           case 48: 
/* 1039 */             long _v_ = 0L;
/* 1040 */             _v_ = _input_.readInt64();
/* 1041 */             this.voteids.add(Long.valueOf(_v_));
/* 1042 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1046 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1048 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1057 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (IOException e)
/*      */       {
/* 1061 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1063 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewName copy()
/*      */     {
/* 1069 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewName toData()
/*      */     {
/* 1075 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.SwornNewName toBean()
/*      */     {
/* 1080 */       return new SwornNewName(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.SwornNewName toDataIf()
/*      */     {
/* 1086 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.SwornNewName toBeanIf()
/*      */     {
/* 1091 */       return new SwornNewName(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1097 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1101 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1105 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1109 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1113 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1117 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1121 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getRoleid()
/*      */     {
/* 1128 */       return this.roleid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName1()
/*      */     {
/* 1135 */       return this.name1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName1Octets()
/*      */     {
/* 1142 */       return Octets.wrap(getName1(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName2()
/*      */     {
/* 1149 */       return this.name2;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName2Octets()
/*      */     {
/* 1156 */       return Octets.wrap(getName2(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getVerifytime()
/*      */     {
/* 1163 */       return this.verifytime;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVerifyids()
/*      */     {
/* 1170 */       return this.verifyids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVerifyidsAsData()
/*      */     {
/* 1177 */       return this.verifyids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVoteids()
/*      */     {
/* 1184 */       return this.voteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getVoteidsAsData()
/*      */     {
/* 1191 */       return this.voteids;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setRoleid(long _v_)
/*      */     {
/* 1198 */       this.roleid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1(String _v_)
/*      */     {
/* 1205 */       if (null == _v_)
/* 1206 */         throw new NullPointerException();
/* 1207 */       this.name1 = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1Octets(Octets _v_)
/*      */     {
/* 1214 */       setName1(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2(String _v_)
/*      */     {
/* 1221 */       if (null == _v_)
/* 1222 */         throw new NullPointerException();
/* 1223 */       this.name2 = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2Octets(Octets _v_)
/*      */     {
/* 1230 */       setName2(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setVerifytime(long _v_)
/*      */     {
/* 1237 */       this.verifytime = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1243 */       if (!(_o1_ instanceof Data)) return false;
/* 1244 */       Data _o_ = (Data)_o1_;
/* 1245 */       if (this.roleid != _o_.roleid) return false;
/* 1246 */       if (!this.name1.equals(_o_.name1)) return false;
/* 1247 */       if (!this.name2.equals(_o_.name2)) return false;
/* 1248 */       if (this.verifytime != _o_.verifytime) return false;
/* 1249 */       if (!this.verifyids.equals(_o_.verifyids)) return false;
/* 1250 */       if (!this.voteids.equals(_o_.voteids)) return false;
/* 1251 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1257 */       int _h_ = 0;
/* 1258 */       _h_ = (int)(_h_ + this.roleid);
/* 1259 */       _h_ += this.name1.hashCode();
/* 1260 */       _h_ += this.name2.hashCode();
/* 1261 */       _h_ = (int)(_h_ + this.verifytime);
/* 1262 */       _h_ += this.verifyids.hashCode();
/* 1263 */       _h_ += this.voteids.hashCode();
/* 1264 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1270 */       StringBuilder _sb_ = new StringBuilder();
/* 1271 */       _sb_.append("(");
/* 1272 */       _sb_.append(this.roleid);
/* 1273 */       _sb_.append(",");
/* 1274 */       _sb_.append("'").append(this.name1).append("'");
/* 1275 */       _sb_.append(",");
/* 1276 */       _sb_.append("'").append(this.name2).append("'");
/* 1277 */       _sb_.append(",");
/* 1278 */       _sb_.append(this.verifytime);
/* 1279 */       _sb_.append(",");
/* 1280 */       _sb_.append(this.verifyids);
/* 1281 */       _sb_.append(",");
/* 1282 */       _sb_.append(this.voteids);
/* 1283 */       _sb_.append(")");
/* 1284 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\SwornNewName.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */