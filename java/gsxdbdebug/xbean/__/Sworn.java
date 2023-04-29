/*      */ package xbean.__;
/*      */ 
/*      */ import com.goldhuman.Common.Marshal.OctetsStream;
/*      */ import com.goldhuman.Common.Octets;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Map.Entry;
/*      */ import ppbio.ByteString;
/*      */ import ppbio.CodedInputStream;
/*      */ import ppbio.CodedOutputStream;
/*      */ import ppbio.InvalidProtocolBufferException;
/*      */ import xdb.LogKey;
/*      */ import xdb.XBean;
/*      */ import xdb.logs.ListenableChanged;
/*      */ 
/*      */ public final class Sworn extends XBean implements xbean.Sworn
/*      */ {
/*      */   private String name1;
/*      */   private String name2;
/*      */   private long createrid;
/*      */   private ArrayList<Long> members;
/*      */   private HashMap<Long, xbean.SwornNewMember> newmember;
/*      */   private xbean.SwornNewName newname;
/*      */   private xbean.SwornKickOut kickoutmember;
/*      */   
/*      */   public void _reset_unsafe_()
/*      */   {
/*   30 */     this.name1 = "";
/*   31 */     this.name2 = "";
/*   32 */     this.createrid = 0L;
/*   33 */     this.members.clear();
/*   34 */     this.newmember.clear();
/*   35 */     this.newname._reset_unsafe_();
/*   36 */     this.kickoutmember._reset_unsafe_();
/*      */   }
/*      */   
/*      */   Sworn(int __, XBean _xp_, String _vn_)
/*      */   {
/*   41 */     super(_xp_, _vn_);
/*   42 */     this.name1 = "";
/*   43 */     this.name2 = "";
/*   44 */     this.members = new ArrayList();
/*   45 */     this.newmember = new HashMap();
/*   46 */     this.newname = new SwornNewName(0, this, "newname");
/*   47 */     this.kickoutmember = new SwornKickOut(0, this, "kickoutmember");
/*      */   }
/*      */   
/*      */   public Sworn()
/*      */   {
/*   52 */     this(0, null, null);
/*      */   }
/*      */   
/*      */   public Sworn(Sworn _o_)
/*      */   {
/*   57 */     this(_o_, null, null);
/*      */   }
/*      */   
/*      */   Sworn(xbean.Sworn _o1_, XBean _xp_, String _vn_)
/*      */   {
/*   62 */     super(_xp_, _vn_);
/*   63 */     if ((_o1_ instanceof Sworn)) { assign((Sworn)_o1_);
/*   64 */     } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*   65 */     } else if ((_o1_ instanceof Const)) assign(((Const)_o1_).nThis()); else {
/*   66 */       throw new UnsupportedOperationException();
/*      */     }
/*      */   }
/*      */   
/*      */   private void assign(Sworn _o_) {
/*   71 */     _o_._xdb_verify_unsafe_();
/*   72 */     this.name1 = _o_.name1;
/*   73 */     this.name2 = _o_.name2;
/*   74 */     this.createrid = _o_.createrid;
/*   75 */     this.members = new ArrayList();
/*   76 */     this.members.addAll(_o_.members);
/*   77 */     this.newmember = new HashMap();
/*   78 */     for (Map.Entry<Long, xbean.SwornNewMember> _e_ : _o_.newmember.entrySet())
/*   79 */       this.newmember.put(_e_.getKey(), new SwornNewMember((xbean.SwornNewMember)_e_.getValue(), this, "newmember"));
/*   80 */     this.newname = new SwornNewName(_o_.newname, this, "newname");
/*   81 */     this.kickoutmember = new SwornKickOut(_o_.kickoutmember, this, "kickoutmember");
/*      */   }
/*      */   
/*      */   private void assign(Data _o_)
/*      */   {
/*   86 */     this.name1 = _o_.name1;
/*   87 */     this.name2 = _o_.name2;
/*   88 */     this.createrid = _o_.createrid;
/*   89 */     this.members = new ArrayList();
/*   90 */     this.members.addAll(_o_.members);
/*   91 */     this.newmember = new HashMap();
/*   92 */     for (Map.Entry<Long, xbean.SwornNewMember> _e_ : _o_.newmember.entrySet())
/*   93 */       this.newmember.put(_e_.getKey(), new SwornNewMember((xbean.SwornNewMember)_e_.getValue(), this, "newmember"));
/*   94 */     this.newname = new SwornNewName(_o_.newname, this, "newname");
/*   95 */     this.kickoutmember = new SwornKickOut(_o_.kickoutmember, this, "kickoutmember");
/*      */   }
/*      */   
/*      */ 
/*      */   public final OctetsStream marshal(OctetsStream _os_)
/*      */   {
/*  101 */     _xdb_verify_unsafe_();
/*  102 */     _os_.marshal(this.name1, "UTF-16LE");
/*  103 */     _os_.marshal(this.name2, "UTF-16LE");
/*  104 */     _os_.marshal(this.createrid);
/*  105 */     _os_.compact_uint32(this.members.size());
/*  106 */     for (Long _v_ : this.members)
/*      */     {
/*  108 */       _os_.marshal(_v_.longValue());
/*      */     }
/*  110 */     _os_.compact_uint32(this.newmember.size());
/*  111 */     for (Map.Entry<Long, xbean.SwornNewMember> _e_ : this.newmember.entrySet())
/*      */     {
/*  113 */       _os_.marshal(((Long)_e_.getKey()).longValue());
/*  114 */       ((xbean.SwornNewMember)_e_.getValue()).marshal(_os_);
/*      */     }
/*  116 */     this.newname.marshal(_os_);
/*  117 */     this.kickoutmember.marshal(_os_);
/*  118 */     return _os_;
/*      */   }
/*      */   
/*      */   public final OctetsStream unmarshal(OctetsStream _os_)
/*      */     throws com.goldhuman.Common.Marshal.MarshalException
/*      */   {
/*  124 */     _xdb_verify_unsafe_();
/*  125 */     this.name1 = _os_.unmarshal_String("UTF-16LE");
/*  126 */     this.name2 = _os_.unmarshal_String("UTF-16LE");
/*  127 */     this.createrid = _os_.unmarshal_long();
/*  128 */     for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */     {
/*  130 */       long _v_ = 0L;
/*  131 */       _v_ = _os_.unmarshal_long();
/*  132 */       this.members.add(Long.valueOf(_v_));
/*      */     }
/*      */     
/*  135 */     int size = _os_.uncompact_uint32();
/*  136 */     if (size >= 12)
/*      */     {
/*  138 */       this.newmember = new HashMap(size * 2);
/*      */     }
/*  140 */     for (; size > 0; size--)
/*      */     {
/*  142 */       long _k_ = 0L;
/*  143 */       _k_ = _os_.unmarshal_long();
/*  144 */       xbean.SwornNewMember _v_ = new SwornNewMember(0, this, "newmember");
/*  145 */       _v_.unmarshal(_os_);
/*  146 */       this.newmember.put(Long.valueOf(_k_), _v_);
/*      */     }
/*      */     
/*  149 */     this.newname.unmarshal(_os_);
/*  150 */     this.kickoutmember.unmarshal(_os_);
/*  151 */     return _os_;
/*      */   }
/*      */   
/*      */ 
/*      */   public int getSerializedSize()
/*      */   {
/*  157 */     _xdb_verify_unsafe_();
/*  158 */     int _size_ = 0;
/*      */     try
/*      */     {
/*  161 */       _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.name1, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  165 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*      */     try
/*      */     {
/*  169 */       _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.name2, "UTF-16LE"));
/*      */     }
/*      */     catch (java.io.UnsupportedEncodingException e)
/*      */     {
/*  173 */       throw new RuntimeException("UTF-16LE not supported?", e);
/*      */     }
/*  175 */     _size_ += CodedOutputStream.computeInt64Size(3, this.createrid);
/*  176 */     for (Long _v_ : this.members)
/*      */     {
/*  178 */       _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */     }
/*  180 */     for (Map.Entry<Long, xbean.SwornNewMember> _e_ : this.newmember.entrySet())
/*      */     {
/*  182 */       _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/*  183 */       _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */     }
/*  185 */     _size_ += CodedOutputStream.computeMessageSize(6, this.newname);
/*  186 */     _size_ += CodedOutputStream.computeMessageSize(7, this.kickoutmember);
/*  187 */     return _size_;
/*      */   }
/*      */   
/*      */   public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  193 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  196 */       _output_.writeBytes(1, ByteString.copyFrom(this.name1, "UTF-16LE"));
/*  197 */       _output_.writeBytes(2, ByteString.copyFrom(this.name2, "UTF-16LE"));
/*  198 */       _output_.writeInt64(3, this.createrid);
/*  199 */       for (Long _v_ : this.members)
/*      */       {
/*  201 */         _output_.writeInt64(4, _v_.longValue());
/*      */       }
/*  203 */       for (Map.Entry<Long, xbean.SwornNewMember> _e_ : this.newmember.entrySet())
/*      */       {
/*  205 */         _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/*  206 */         _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */       }
/*  208 */       _output_.writeMessage(6, this.newname);
/*  209 */       _output_.writeMessage(7, this.kickoutmember);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  213 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  215 */     return _output_;
/*      */   }
/*      */   
/*      */   public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */     throws InvalidProtocolBufferException
/*      */   {
/*  221 */     _xdb_verify_unsafe_();
/*      */     try
/*      */     {
/*  224 */       boolean done = false;
/*  225 */       while (!done)
/*      */       {
/*  227 */         int tag = _input_.readTag();
/*  228 */         switch (tag)
/*      */         {
/*      */ 
/*      */         case 0: 
/*  232 */           done = true;
/*  233 */           break;
/*      */         
/*      */ 
/*      */         case 10: 
/*  237 */           this.name1 = _input_.readBytes().toString("UTF-16LE");
/*  238 */           break;
/*      */         
/*      */ 
/*      */         case 18: 
/*  242 */           this.name2 = _input_.readBytes().toString("UTF-16LE");
/*  243 */           break;
/*      */         
/*      */ 
/*      */         case 24: 
/*  247 */           this.createrid = _input_.readInt64();
/*  248 */           break;
/*      */         
/*      */ 
/*      */         case 32: 
/*  252 */           long _v_ = 0L;
/*  253 */           _v_ = _input_.readInt64();
/*  254 */           this.members.add(Long.valueOf(_v_));
/*  255 */           break;
/*      */         
/*      */ 
/*      */         case 40: 
/*  259 */           long _k_ = 0L;
/*  260 */           _k_ = _input_.readInt64();
/*  261 */           int readTag = _input_.readTag();
/*  262 */           if (42 != readTag)
/*      */           {
/*  264 */             throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */           }
/*  266 */           xbean.SwornNewMember _v_ = new SwornNewMember(0, this, "newmember");
/*  267 */           _input_.readMessage(_v_);
/*  268 */           this.newmember.put(Long.valueOf(_k_), _v_);
/*  269 */           break;
/*      */         
/*      */ 
/*      */         case 50: 
/*  273 */           _input_.readMessage(this.newname);
/*  274 */           break;
/*      */         
/*      */ 
/*      */         case 58: 
/*  278 */           _input_.readMessage(this.kickoutmember);
/*  279 */           break;
/*      */         
/*      */ 
/*      */         default: 
/*  283 */           if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */           {
/*  285 */             done = true;
/*      */           }
/*      */           break;
/*      */         }
/*      */         
/*      */       }
/*      */     }
/*      */     catch (InvalidProtocolBufferException e)
/*      */     {
/*  294 */       throw e.setUnfinishedMessage(this);
/*      */     }
/*      */     catch (java.io.IOException e)
/*      */     {
/*  298 */       throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */     }
/*  300 */     return _input_;
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Sworn copy()
/*      */   {
/*  306 */     _xdb_verify_unsafe_();
/*  307 */     return new Sworn(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Sworn toData()
/*      */   {
/*  313 */     _xdb_verify_unsafe_();
/*  314 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Sworn toBean()
/*      */   {
/*  319 */     _xdb_verify_unsafe_();
/*  320 */     return new Sworn(this);
/*      */   }
/*      */   
/*      */ 
/*      */   public xbean.Sworn toDataIf()
/*      */   {
/*  326 */     _xdb_verify_unsafe_();
/*  327 */     return new Data(this);
/*      */   }
/*      */   
/*      */   public xbean.Sworn toBeanIf()
/*      */   {
/*  332 */     _xdb_verify_unsafe_();
/*  333 */     return this;
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.Bean toConst()
/*      */   {
/*  339 */     _xdb_verify_unsafe_();
/*  340 */     return new Const(null);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName1()
/*      */   {
/*  347 */     _xdb_verify_unsafe_();
/*  348 */     return this.name1;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getName1Octets()
/*      */   {
/*  355 */     _xdb_verify_unsafe_();
/*  356 */     return Octets.wrap(getName1(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public String getName2()
/*      */   {
/*  363 */     _xdb_verify_unsafe_();
/*  364 */     return this.name2;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Octets getName2Octets()
/*      */   {
/*  371 */     _xdb_verify_unsafe_();
/*  372 */     return Octets.wrap(getName2(), "UTF-16LE");
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public long getCreaterid()
/*      */   {
/*  379 */     _xdb_verify_unsafe_();
/*  380 */     return this.createrid;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public List<Long> getMembers()
/*      */   {
/*  387 */     _xdb_verify_unsafe_();
/*  388 */     return xdb.Logs.logList(new LogKey(this, "members"), this.members);
/*      */   }
/*      */   
/*      */ 
/*      */   public List<Long> getMembersAsData()
/*      */   {
/*  394 */     _xdb_verify_unsafe_();
/*      */     
/*  396 */     Sworn _o_ = this;
/*  397 */     List<Long> members = new ArrayList();
/*  398 */     members.addAll(_o_.members);
/*  399 */     return members;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.SwornNewMember> getNewmember()
/*      */   {
/*  406 */     _xdb_verify_unsafe_();
/*  407 */     return xdb.Logs.logMap(new LogKey(this, "newmember"), this.newmember);
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public Map<Long, xbean.SwornNewMember> getNewmemberAsData()
/*      */   {
/*  414 */     _xdb_verify_unsafe_();
/*      */     
/*  416 */     Sworn _o_ = this;
/*  417 */     Map<Long, xbean.SwornNewMember> newmember = new HashMap();
/*  418 */     for (Map.Entry<Long, xbean.SwornNewMember> _e_ : _o_.newmember.entrySet())
/*  419 */       newmember.put(_e_.getKey(), new SwornNewMember.Data((xbean.SwornNewMember)_e_.getValue()));
/*  420 */     return newmember;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.SwornNewName getNewname()
/*      */   {
/*  427 */     _xdb_verify_unsafe_();
/*  428 */     return this.newname;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public xbean.SwornKickOut getKickoutmember()
/*      */   {
/*  435 */     _xdb_verify_unsafe_();
/*  436 */     return this.kickoutmember;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName1(String _v_)
/*      */   {
/*  443 */     _xdb_verify_unsafe_();
/*  444 */     if (null == _v_)
/*  445 */       throw new NullPointerException();
/*  446 */     xdb.Logs.logIf(new LogKey(this, "name1")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  450 */         new xdb.logs.LogString(this, Sworn.this.name1)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  454 */             Sworn.this.name1 = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  458 */     });
/*  459 */     this.name1 = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName1Octets(Octets _v_)
/*      */   {
/*  466 */     _xdb_verify_unsafe_();
/*  467 */     setName1(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName2(String _v_)
/*      */   {
/*  474 */     _xdb_verify_unsafe_();
/*  475 */     if (null == _v_)
/*  476 */       throw new NullPointerException();
/*  477 */     xdb.Logs.logIf(new LogKey(this, "name2")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  481 */         new xdb.logs.LogString(this, Sworn.this.name2)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  485 */             Sworn.this.name2 = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  489 */     });
/*  490 */     this.name2 = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setName2Octets(Octets _v_)
/*      */   {
/*  497 */     _xdb_verify_unsafe_();
/*  498 */     setName2(_v_.getString("UTF-16LE"));
/*      */   }
/*      */   
/*      */ 
/*      */ 
/*      */   public void setCreaterid(long _v_)
/*      */   {
/*  505 */     _xdb_verify_unsafe_();
/*  506 */     xdb.Logs.logIf(new LogKey(this, "createrid")
/*      */     {
/*      */       protected xdb.Log create()
/*      */       {
/*  510 */         new xdb.logs.LogLong(this, Sworn.this.createrid)
/*      */         {
/*      */           public void rollback()
/*      */           {
/*  514 */             Sworn.this.createrid = this._xdb_saved;
/*      */           }
/*      */         };
/*      */       }
/*  518 */     });
/*  519 */     this.createrid = _v_;
/*      */   }
/*      */   
/*      */ 
/*      */   public final boolean equals(Object _o1_)
/*      */   {
/*  525 */     _xdb_verify_unsafe_();
/*  526 */     Sworn _o_ = null;
/*  527 */     if ((_o1_ instanceof Sworn)) { _o_ = (Sworn)_o1_;
/*  528 */     } else if ((_o1_ instanceof Const)) _o_ = ((Const)_o1_).nThis(); else
/*  529 */       return false;
/*  530 */     if (!this.name1.equals(_o_.name1)) return false;
/*  531 */     if (!this.name2.equals(_o_.name2)) return false;
/*  532 */     if (this.createrid != _o_.createrid) return false;
/*  533 */     if (!this.members.equals(_o_.members)) return false;
/*  534 */     if (!this.newmember.equals(_o_.newmember)) return false;
/*  535 */     if (!this.newname.equals(_o_.newname)) return false;
/*  536 */     if (!this.kickoutmember.equals(_o_.kickoutmember)) return false;
/*  537 */     return true;
/*      */   }
/*      */   
/*      */ 
/*      */   public final int hashCode()
/*      */   {
/*  543 */     _xdb_verify_unsafe_();
/*  544 */     int _h_ = 0;
/*  545 */     _h_ += this.name1.hashCode();
/*  546 */     _h_ += this.name2.hashCode();
/*  547 */     _h_ = (int)(_h_ + this.createrid);
/*  548 */     _h_ += this.members.hashCode();
/*  549 */     _h_ += this.newmember.hashCode();
/*  550 */     _h_ += this.newname.hashCode();
/*  551 */     _h_ += this.kickoutmember.hashCode();
/*  552 */     return _h_;
/*      */   }
/*      */   
/*      */ 
/*      */   public String toString()
/*      */   {
/*  558 */     _xdb_verify_unsafe_();
/*  559 */     StringBuilder _sb_ = new StringBuilder();
/*  560 */     _sb_.append("(");
/*  561 */     _sb_.append("'").append(this.name1).append("'");
/*  562 */     _sb_.append(",");
/*  563 */     _sb_.append("'").append(this.name2).append("'");
/*  564 */     _sb_.append(",");
/*  565 */     _sb_.append(this.createrid);
/*  566 */     _sb_.append(",");
/*  567 */     _sb_.append(this.members);
/*  568 */     _sb_.append(",");
/*  569 */     _sb_.append(this.newmember);
/*  570 */     _sb_.append(",");
/*  571 */     _sb_.append(this.newname);
/*  572 */     _sb_.append(",");
/*  573 */     _sb_.append(this.kickoutmember);
/*  574 */     _sb_.append(")");
/*  575 */     return _sb_.toString();
/*      */   }
/*      */   
/*      */ 
/*      */   public xdb.logs.Listenable newListenable()
/*      */   {
/*  581 */     xdb.logs.ListenableBean lb = new xdb.logs.ListenableBean();
/*  582 */     lb.add(new ListenableChanged().setVarName("name1"));
/*  583 */     lb.add(new ListenableChanged().setVarName("name2"));
/*  584 */     lb.add(new ListenableChanged().setVarName("createrid"));
/*  585 */     lb.add(new ListenableChanged().setVarName("members"));
/*  586 */     lb.add(new xdb.logs.ListenableMap().setVarName("newmember"));
/*  587 */     lb.add(new ListenableChanged().setVarName("newname"));
/*  588 */     lb.add(new ListenableChanged().setVarName("kickoutmember"));
/*  589 */     return lb;
/*      */   }
/*      */   
/*      */   private class Const implements xbean.Sworn {
/*      */     private Const() {}
/*      */     
/*      */     Sworn nThis() {
/*  596 */       return Sworn.this;
/*      */     }
/*      */     
/*      */ 
/*      */     public void _reset_unsafe_()
/*      */     {
/*  602 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sworn copy()
/*      */     {
/*  608 */       return Sworn.this.copy();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sworn toData()
/*      */     {
/*  614 */       return Sworn.this.toData();
/*      */     }
/*      */     
/*      */     public xbean.Sworn toBean()
/*      */     {
/*  619 */       return Sworn.this.toBean();
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sworn toDataIf()
/*      */     {
/*  625 */       return Sworn.this.toDataIf();
/*      */     }
/*      */     
/*      */     public xbean.Sworn toBeanIf()
/*      */     {
/*  630 */       return Sworn.this.toBeanIf();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName1()
/*      */     {
/*  637 */       Sworn.this._xdb_verify_unsafe_();
/*  638 */       return Sworn.this.name1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName1Octets()
/*      */     {
/*  645 */       Sworn.this._xdb_verify_unsafe_();
/*  646 */       return Sworn.this.getName1Octets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName2()
/*      */     {
/*  653 */       Sworn.this._xdb_verify_unsafe_();
/*  654 */       return Sworn.this.name2;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName2Octets()
/*      */     {
/*  661 */       Sworn.this._xdb_verify_unsafe_();
/*  662 */       return Sworn.this.getName2Octets();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreaterid()
/*      */     {
/*  669 */       Sworn.this._xdb_verify_unsafe_();
/*  670 */       return Sworn.this.createrid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMembers()
/*      */     {
/*  677 */       Sworn.this._xdb_verify_unsafe_();
/*  678 */       return xdb.Consts.constList(Sworn.this.members);
/*      */     }
/*      */     
/*      */ 
/*      */     public List<Long> getMembersAsData()
/*      */     {
/*  684 */       Sworn.this._xdb_verify_unsafe_();
/*      */       
/*  686 */       Sworn _o_ = Sworn.this;
/*  687 */       List<Long> members = new ArrayList();
/*  688 */       members.addAll(_o_.members);
/*  689 */       return members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.SwornNewMember> getNewmember()
/*      */     {
/*  696 */       Sworn.this._xdb_verify_unsafe_();
/*  697 */       return xdb.Consts.constMap(Sworn.this.newmember);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.SwornNewMember> getNewmemberAsData()
/*      */     {
/*  704 */       Sworn.this._xdb_verify_unsafe_();
/*      */       
/*  706 */       Sworn _o_ = Sworn.this;
/*  707 */       Map<Long, xbean.SwornNewMember> newmember = new HashMap();
/*  708 */       for (Map.Entry<Long, xbean.SwornNewMember> _e_ : _o_.newmember.entrySet())
/*  709 */         newmember.put(_e_.getKey(), new SwornNewMember.Data((xbean.SwornNewMember)_e_.getValue()));
/*  710 */       return newmember;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SwornNewName getNewname()
/*      */     {
/*  717 */       Sworn.this._xdb_verify_unsafe_();
/*  718 */       return (xbean.SwornNewName)xdb.Consts.toConst(Sworn.this.newname);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SwornKickOut getKickoutmember()
/*      */     {
/*  725 */       Sworn.this._xdb_verify_unsafe_();
/*  726 */       return (xbean.SwornKickOut)xdb.Consts.toConst(Sworn.this.kickoutmember);
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1(String _v_)
/*      */     {
/*  733 */       Sworn.this._xdb_verify_unsafe_();
/*  734 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1Octets(Octets _v_)
/*      */     {
/*  741 */       Sworn.this._xdb_verify_unsafe_();
/*  742 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2(String _v_)
/*      */     {
/*  749 */       Sworn.this._xdb_verify_unsafe_();
/*  750 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2Octets(Octets _v_)
/*      */     {
/*  757 */       Sworn.this._xdb_verify_unsafe_();
/*  758 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreaterid(long _v_)
/*      */     {
/*  765 */       Sworn.this._xdb_verify_unsafe_();
/*  766 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean toConst()
/*      */     {
/*  772 */       Sworn.this._xdb_verify_unsafe_();
/*  773 */       return this;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isConst()
/*      */     {
/*  779 */       Sworn.this._xdb_verify_unsafe_();
/*  780 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean isData()
/*      */     {
/*  786 */       return Sworn.this.isData();
/*      */     }
/*      */     
/*      */ 
/*      */     public OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  792 */       return Sworn.this.marshal(_os_);
/*      */     }
/*      */     
/*      */     public OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  798 */       Sworn.this._xdb_verify_unsafe_();
/*  799 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public int getSerializedSize()
/*      */     {
/*  805 */       return Sworn.this.getSerializedSize();
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  811 */       return Sworn.this.marshal(_output_);
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*  817 */       Sworn.this._xdb_verify_unsafe_();
/*  818 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */ 
/*      */     public xdb.Bean xdbParent()
/*      */     {
/*  824 */       return Sworn.this.xdbParent();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/*  830 */       return Sworn.this.xdbManaged();
/*      */     }
/*      */     
/*      */ 
/*      */     public String xdbVarname()
/*      */     {
/*  836 */       return Sworn.this.xdbVarname();
/*      */     }
/*      */     
/*      */ 
/*      */     public Long xdbObjId()
/*      */     {
/*  842 */       return Sworn.this.xdbObjId();
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean equals(Object obj)
/*      */     {
/*  848 */       return Sworn.this.equals(obj);
/*      */     }
/*      */     
/*      */ 
/*      */     public int hashCode()
/*      */     {
/*  854 */       return Sworn.this.hashCode();
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/*  860 */       return Sworn.this.toString();
/*      */     }
/*      */   }
/*      */   
/*      */ 
/*      */   public static final class Data
/*      */     implements xbean.Sworn
/*      */   {
/*      */     private String name1;
/*      */     
/*      */     private String name2;
/*      */     
/*      */     private long createrid;
/*      */     
/*      */     private ArrayList<Long> members;
/*      */     
/*      */     private HashMap<Long, xbean.SwornNewMember> newmember;
/*      */     
/*      */     private xbean.SwornNewName newname;
/*      */     
/*      */     private xbean.SwornKickOut kickoutmember;
/*      */     
/*      */     public void _reset_unsafe_()
/*      */     {
/*  884 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Data()
/*      */     {
/*  889 */       this.name1 = "";
/*  890 */       this.name2 = "";
/*  891 */       this.members = new ArrayList();
/*  892 */       this.newmember = new HashMap();
/*  893 */       this.newname = new SwornNewName.Data();
/*  894 */       this.kickoutmember = new SwornKickOut.Data();
/*      */     }
/*      */     
/*      */     Data(xbean.Sworn _o1_)
/*      */     {
/*  899 */       if ((_o1_ instanceof Sworn)) { assign((Sworn)_o1_);
/*  900 */       } else if ((_o1_ instanceof Data)) { assign((Data)_o1_);
/*  901 */       } else if ((_o1_ instanceof Sworn.Const)) assign(((Sworn.Const)_o1_).nThis()); else {
/*  902 */         throw new UnsupportedOperationException();
/*      */       }
/*      */     }
/*      */     
/*      */     private void assign(Sworn _o_) {
/*  907 */       this.name1 = _o_.name1;
/*  908 */       this.name2 = _o_.name2;
/*  909 */       this.createrid = _o_.createrid;
/*  910 */       this.members = new ArrayList();
/*  911 */       this.members.addAll(_o_.members);
/*  912 */       this.newmember = new HashMap();
/*  913 */       for (Map.Entry<Long, xbean.SwornNewMember> _e_ : _o_.newmember.entrySet())
/*  914 */         this.newmember.put(_e_.getKey(), new SwornNewMember.Data((xbean.SwornNewMember)_e_.getValue()));
/*  915 */       this.newname = new SwornNewName.Data(_o_.newname);
/*  916 */       this.kickoutmember = new SwornKickOut.Data(_o_.kickoutmember);
/*      */     }
/*      */     
/*      */     private void assign(Data _o_)
/*      */     {
/*  921 */       this.name1 = _o_.name1;
/*  922 */       this.name2 = _o_.name2;
/*  923 */       this.createrid = _o_.createrid;
/*  924 */       this.members = new ArrayList();
/*  925 */       this.members.addAll(_o_.members);
/*  926 */       this.newmember = new HashMap();
/*  927 */       for (Map.Entry<Long, xbean.SwornNewMember> _e_ : _o_.newmember.entrySet())
/*  928 */         this.newmember.put(_e_.getKey(), new SwornNewMember.Data((xbean.SwornNewMember)_e_.getValue()));
/*  929 */       this.newname = new SwornNewName.Data(_o_.newname);
/*  930 */       this.kickoutmember = new SwornKickOut.Data(_o_.kickoutmember);
/*      */     }
/*      */     
/*      */ 
/*      */     public final OctetsStream marshal(OctetsStream _os_)
/*      */     {
/*  936 */       _os_.marshal(this.name1, "UTF-16LE");
/*  937 */       _os_.marshal(this.name2, "UTF-16LE");
/*  938 */       _os_.marshal(this.createrid);
/*  939 */       _os_.compact_uint32(this.members.size());
/*  940 */       for (Long _v_ : this.members)
/*      */       {
/*  942 */         _os_.marshal(_v_.longValue());
/*      */       }
/*  944 */       _os_.compact_uint32(this.newmember.size());
/*  945 */       for (Map.Entry<Long, xbean.SwornNewMember> _e_ : this.newmember.entrySet())
/*      */       {
/*  947 */         _os_.marshal(((Long)_e_.getKey()).longValue());
/*  948 */         ((xbean.SwornNewMember)_e_.getValue()).marshal(_os_);
/*      */       }
/*  950 */       this.newname.marshal(_os_);
/*  951 */       this.kickoutmember.marshal(_os_);
/*  952 */       return _os_;
/*      */     }
/*      */     
/*      */     public final OctetsStream unmarshal(OctetsStream _os_)
/*      */       throws com.goldhuman.Common.Marshal.MarshalException
/*      */     {
/*  958 */       this.name1 = _os_.unmarshal_String("UTF-16LE");
/*  959 */       this.name2 = _os_.unmarshal_String("UTF-16LE");
/*  960 */       this.createrid = _os_.unmarshal_long();
/*  961 */       for (int size = _os_.uncompact_uint32(); size > 0; size--)
/*      */       {
/*  963 */         long _v_ = 0L;
/*  964 */         _v_ = _os_.unmarshal_long();
/*  965 */         this.members.add(Long.valueOf(_v_));
/*      */       }
/*      */       
/*  968 */       int size = _os_.uncompact_uint32();
/*  969 */       if (size >= 12)
/*      */       {
/*  971 */         this.newmember = new HashMap(size * 2);
/*      */       }
/*  973 */       for (; size > 0; size--)
/*      */       {
/*  975 */         long _k_ = 0L;
/*  976 */         _k_ = _os_.unmarshal_long();
/*  977 */         xbean.SwornNewMember _v_ = xbean.Pod.newSwornNewMemberData();
/*  978 */         _v_.unmarshal(_os_);
/*  979 */         this.newmember.put(Long.valueOf(_k_), _v_);
/*      */       }
/*      */       
/*  982 */       this.newname.unmarshal(_os_);
/*  983 */       this.kickoutmember.unmarshal(_os_);
/*  984 */       return _os_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int getSerializedSize()
/*      */     {
/*  990 */       int _size_ = 0;
/*      */       try
/*      */       {
/*  993 */         _size_ += CodedOutputStream.computeBytesSize(1, ByteString.copyFrom(this.name1, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/*  997 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/*      */       try
/*      */       {
/* 1001 */         _size_ += CodedOutputStream.computeBytesSize(2, ByteString.copyFrom(this.name2, "UTF-16LE"));
/*      */       }
/*      */       catch (java.io.UnsupportedEncodingException e)
/*      */       {
/* 1005 */         throw new RuntimeException("UTF-16LE not supported?", e);
/*      */       }
/* 1007 */       _size_ += CodedOutputStream.computeInt64Size(3, this.createrid);
/* 1008 */       for (Long _v_ : this.members)
/*      */       {
/* 1010 */         _size_ += CodedOutputStream.computeInt64Size(4, _v_.longValue());
/*      */       }
/* 1012 */       for (Map.Entry<Long, xbean.SwornNewMember> _e_ : this.newmember.entrySet())
/*      */       {
/* 1014 */         _size_ += CodedOutputStream.computeInt64Size(5, ((Long)_e_.getKey()).longValue());
/* 1015 */         _size_ += CodedOutputStream.computeMessageSize(5, (ppbio.Message)_e_.getValue());
/*      */       }
/* 1017 */       _size_ += CodedOutputStream.computeMessageSize(6, this.newname);
/* 1018 */       _size_ += CodedOutputStream.computeMessageSize(7, this.kickoutmember);
/* 1019 */       return _size_;
/*      */     }
/*      */     
/*      */     public CodedOutputStream marshal(CodedOutputStream _output_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1027 */         _output_.writeBytes(1, ByteString.copyFrom(this.name1, "UTF-16LE"));
/* 1028 */         _output_.writeBytes(2, ByteString.copyFrom(this.name2, "UTF-16LE"));
/* 1029 */         _output_.writeInt64(3, this.createrid);
/* 1030 */         for (Long _v_ : this.members)
/*      */         {
/* 1032 */           _output_.writeInt64(4, _v_.longValue());
/*      */         }
/* 1034 */         for (Map.Entry<Long, xbean.SwornNewMember> _e_ : this.newmember.entrySet())
/*      */         {
/* 1036 */           _output_.writeInt64(5, ((Long)_e_.getKey()).longValue());
/* 1037 */           _output_.writeMessage(5, (ppbio.Message)_e_.getValue());
/*      */         }
/* 1039 */         _output_.writeMessage(6, this.newname);
/* 1040 */         _output_.writeMessage(7, this.kickoutmember);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1044 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1046 */       return _output_;
/*      */     }
/*      */     
/*      */     public CodedInputStream unmarshal(CodedInputStream _input_)
/*      */       throws InvalidProtocolBufferException
/*      */     {
/*      */       try
/*      */       {
/* 1054 */         boolean done = false;
/* 1055 */         while (!done)
/*      */         {
/* 1057 */           int tag = _input_.readTag();
/* 1058 */           switch (tag)
/*      */           {
/*      */ 
/*      */           case 0: 
/* 1062 */             done = true;
/* 1063 */             break;
/*      */           
/*      */ 
/*      */           case 10: 
/* 1067 */             this.name1 = _input_.readBytes().toString("UTF-16LE");
/* 1068 */             break;
/*      */           
/*      */ 
/*      */           case 18: 
/* 1072 */             this.name2 = _input_.readBytes().toString("UTF-16LE");
/* 1073 */             break;
/*      */           
/*      */ 
/*      */           case 24: 
/* 1077 */             this.createrid = _input_.readInt64();
/* 1078 */             break;
/*      */           
/*      */ 
/*      */           case 32: 
/* 1082 */             long _v_ = 0L;
/* 1083 */             _v_ = _input_.readInt64();
/* 1084 */             this.members.add(Long.valueOf(_v_));
/* 1085 */             break;
/*      */           
/*      */ 
/*      */           case 40: 
/* 1089 */             long _k_ = 0L;
/* 1090 */             _k_ = _input_.readInt64();
/* 1091 */             int readTag = _input_.readTag();
/* 1092 */             if (42 != readTag)
/*      */             {
/* 1094 */               throw new InvalidProtocolBufferException("Protocol message map-key-value tag did not match expected tag.");
/*      */             }
/* 1096 */             xbean.SwornNewMember _v_ = xbean.Pod.newSwornNewMemberData();
/* 1097 */             _input_.readMessage(_v_);
/* 1098 */             this.newmember.put(Long.valueOf(_k_), _v_);
/* 1099 */             break;
/*      */           
/*      */ 
/*      */           case 50: 
/* 1103 */             _input_.readMessage(this.newname);
/* 1104 */             break;
/*      */           
/*      */ 
/*      */           case 58: 
/* 1108 */             _input_.readMessage(this.kickoutmember);
/* 1109 */             break;
/*      */           
/*      */ 
/*      */           default: 
/* 1113 */             if (!CodedInputStream.skipUnknownField(tag, _input_))
/*      */             {
/* 1115 */               done = true;
/*      */             }
/*      */             break;
/*      */           }
/*      */           
/*      */         }
/*      */       }
/*      */       catch (InvalidProtocolBufferException e)
/*      */       {
/* 1124 */         throw e.setUnfinishedMessage(this);
/*      */       }
/*      */       catch (java.io.IOException e)
/*      */       {
/* 1128 */         throw new InvalidProtocolBufferException(e).setUnfinishedMessage(this);
/*      */       }
/* 1130 */       return _input_;
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sworn copy()
/*      */     {
/* 1136 */       return new Data(this);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sworn toData()
/*      */     {
/* 1142 */       return new Data(this);
/*      */     }
/*      */     
/*      */     public xbean.Sworn toBean()
/*      */     {
/* 1147 */       return new Sworn(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public xbean.Sworn toDataIf()
/*      */     {
/* 1153 */       return this;
/*      */     }
/*      */     
/*      */     public xbean.Sworn toBeanIf()
/*      */     {
/* 1158 */       return new Sworn(this, null, null);
/*      */     }
/*      */     
/*      */ 
/*      */     public boolean xdbManaged()
/*      */     {
/* 1164 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean xdbParent() {
/* 1168 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public String xdbVarname() {
/* 1172 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public Long xdbObjId() {
/* 1176 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public xdb.Bean toConst() {
/* 1180 */       throw new UnsupportedOperationException();
/*      */     }
/*      */     
/*      */     public boolean isConst() {
/* 1184 */       return false;
/*      */     }
/*      */     
/*      */     public boolean isData() {
/* 1188 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName1()
/*      */     {
/* 1195 */       return this.name1;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName1Octets()
/*      */     {
/* 1202 */       return Octets.wrap(getName1(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public String getName2()
/*      */     {
/* 1209 */       return this.name2;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Octets getName2Octets()
/*      */     {
/* 1216 */       return Octets.wrap(getName2(), "UTF-16LE");
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public long getCreaterid()
/*      */     {
/* 1223 */       return this.createrid;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMembers()
/*      */     {
/* 1230 */       return this.members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public List<Long> getMembersAsData()
/*      */     {
/* 1237 */       return this.members;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.SwornNewMember> getNewmember()
/*      */     {
/* 1244 */       return this.newmember;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public Map<Long, xbean.SwornNewMember> getNewmemberAsData()
/*      */     {
/* 1251 */       return this.newmember;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SwornNewName getNewname()
/*      */     {
/* 1258 */       return this.newname;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public xbean.SwornKickOut getKickoutmember()
/*      */     {
/* 1265 */       return this.kickoutmember;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1(String _v_)
/*      */     {
/* 1272 */       if (null == _v_)
/* 1273 */         throw new NullPointerException();
/* 1274 */       this.name1 = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName1Octets(Octets _v_)
/*      */     {
/* 1281 */       setName1(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2(String _v_)
/*      */     {
/* 1288 */       if (null == _v_)
/* 1289 */         throw new NullPointerException();
/* 1290 */       this.name2 = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setName2Octets(Octets _v_)
/*      */     {
/* 1297 */       setName2(_v_.getString("UTF-16LE"));
/*      */     }
/*      */     
/*      */ 
/*      */ 
/*      */     public void setCreaterid(long _v_)
/*      */     {
/* 1304 */       this.createrid = _v_;
/*      */     }
/*      */     
/*      */ 
/*      */     public final boolean equals(Object _o1_)
/*      */     {
/* 1310 */       if (!(_o1_ instanceof Data)) return false;
/* 1311 */       Data _o_ = (Data)_o1_;
/* 1312 */       if (!this.name1.equals(_o_.name1)) return false;
/* 1313 */       if (!this.name2.equals(_o_.name2)) return false;
/* 1314 */       if (this.createrid != _o_.createrid) return false;
/* 1315 */       if (!this.members.equals(_o_.members)) return false;
/* 1316 */       if (!this.newmember.equals(_o_.newmember)) return false;
/* 1317 */       if (!this.newname.equals(_o_.newname)) return false;
/* 1318 */       if (!this.kickoutmember.equals(_o_.kickoutmember)) return false;
/* 1319 */       return true;
/*      */     }
/*      */     
/*      */ 
/*      */     public final int hashCode()
/*      */     {
/* 1325 */       int _h_ = 0;
/* 1326 */       _h_ += this.name1.hashCode();
/* 1327 */       _h_ += this.name2.hashCode();
/* 1328 */       _h_ = (int)(_h_ + this.createrid);
/* 1329 */       _h_ += this.members.hashCode();
/* 1330 */       _h_ += this.newmember.hashCode();
/* 1331 */       _h_ += this.newname.hashCode();
/* 1332 */       _h_ += this.kickoutmember.hashCode();
/* 1333 */       return _h_;
/*      */     }
/*      */     
/*      */ 
/*      */     public String toString()
/*      */     {
/* 1339 */       StringBuilder _sb_ = new StringBuilder();
/* 1340 */       _sb_.append("(");
/* 1341 */       _sb_.append("'").append(this.name1).append("'");
/* 1342 */       _sb_.append(",");
/* 1343 */       _sb_.append("'").append(this.name2).append("'");
/* 1344 */       _sb_.append(",");
/* 1345 */       _sb_.append(this.createrid);
/* 1346 */       _sb_.append(",");
/* 1347 */       _sb_.append(this.members);
/* 1348 */       _sb_.append(",");
/* 1349 */       _sb_.append(this.newmember);
/* 1350 */       _sb_.append(",");
/* 1351 */       _sb_.append(this.newname);
/* 1352 */       _sb_.append(",");
/* 1353 */       _sb_.append(this.kickoutmember);
/* 1354 */       _sb_.append(")");
/* 1355 */       return _sb_.toString();
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\桌面\山海\gsxdbdebug.jar!\xbean\__\Sworn.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */